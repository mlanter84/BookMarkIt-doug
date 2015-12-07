package com.bookmarkit.controller;

import com.bookmarkit.domain.User;
import com.bookmarkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.NoSuchElementException;

/**
 * Created by 580782 on 11/27/2015.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getHomePage() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            String username = auth.getName();

            User user = userService.getUserByUsername(username).orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", username)));
            return "redirect:/users/" + user.getId();
        }

        return "home";
    }
}
