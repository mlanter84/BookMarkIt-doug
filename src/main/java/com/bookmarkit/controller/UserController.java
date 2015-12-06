package com.bookmarkit.controller;

import com.bookmarkit.domain.Bookmark;
import com.bookmarkit.domain.User;
import com.bookmarkit.form.BookmarkCreateForm;
import com.bookmarkit.form.UserCreateForm;
import com.bookmarkit.service.BookmarkSerivce;
import com.bookmarkit.service.CurrentUserDetailsService;
import com.bookmarkit.service.UserService;
import com.bookmarkit.validator.UserCreateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by 580782 on 11/25/2015.
 */

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;
    private final AuthenticationManager authenticationManager;


    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator,
                          AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
        this.authenticationManager = authenticationManager;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

/*    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUserPage(@PathVariable(value = "id") Long id, Model model) {

        model.addAttribute("user", userService.getUserById(id)
            .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));

        return "userPage";

    }*/

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getUserCreatePage(Model model) {

        model.addAttribute("form", new UserCreateForm());


        return "user/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postUserCreatePage(
            @Valid @ModelAttribute("form") UserCreateForm form,
            BindingResult bindingResult,
            RedirectAttributes model,
            HttpServletRequest request) {

        User user = null;

        if (bindingResult.hasErrors()) {
            return "user/create";
        }

        try {
            user = userService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("username.exists", "Username already exists");
            return "user/create";
        }

        model.addFlashAttribute("user", user);

        authenticateUserAndSetSession(user, request);

        return "redirect:/users/" + user.getId();
    }

    private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
        String username = user.getUsername();
        String password = user.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #userId)")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String showUserDashboard(@PathVariable("userId") Long userId,
                                    Model model) {

        //
        User user = null;

        if (!model.containsAttribute("user")) {
            user = userService.getUserById(userId)
                    .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", userId)));
        } else {
            user = (User)model.asMap().get("user");
        }

        List<Bookmark> bookmarks;
        bookmarks= user.getBookmarks().orElse(new ArrayList<>());
        model.addAttribute("user", user);
        model.addAttribute("bookmarks", bookmarks);

        return "user/dashboard";
    }
}
