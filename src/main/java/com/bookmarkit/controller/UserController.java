package com.bookmarkit.controller;

import com.bookmarkit.domain.User;
import com.bookmarkit.form.UserCreateForm;
import com.bookmarkit.service.UserService;
import com.bookmarkit.validator.UserCreateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.NoSuchElementException;

/**
 * Created by 580782 on 11/25/2015.
 */

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
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
            RedirectAttributes model) {

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

        model.addAttribute("user", user);
        model.addAttribute("userId", user.getId());

        return "redirect:/{userId}";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String showUserDashboard(@PathVariable("userId") Long userId,
                                    Model model) {

        // need error handling

        User user = userService.getUserById(userId)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", userId)));

        model.addAttribute("user", user);

        return "user/dashboard";
    }
}
