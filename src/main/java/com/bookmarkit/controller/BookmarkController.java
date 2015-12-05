package com.bookmarkit.controller;

import com.bookmarkit.domain.Bookmark;
import com.bookmarkit.domain.User;
import com.bookmarkit.form.BookmarkCreateForm;
import com.bookmarkit.service.BookmarkSerivce;
import com.bookmarkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.NoSuchElementException;

/**
 * Created by 580782 on 11/29/2015.
 */

@RestController
public class BookmarkController {

    private final UserService userService;

    private final BookmarkSerivce bookmarkSerivce;

    @Autowired
    public BookmarkController(UserService userService, BookmarkSerivce bookmarkSerivce) {
        this.userService = userService;
        this.bookmarkSerivce = bookmarkSerivce;
    }

    @RequestMapping("{userId}/add")
    public Bookmark addBookmark(@PathVariable("userId") Long userId, @RequestBody BookmarkCreateForm form) {

        User user = userService.getUserById(userId)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", userId)));

        form.setUser(user);
        Bookmark bookmark = bookmarkSerivce.create(form);

        return bookmark;
    }

/*    @RequestMapping("{userId}/view/{bookmarkId}")
    public Bookmark viewBookmark(@PathVariable("userId") Long userId, @PathVariable("bookmarkId") Long bookmarkId) {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", userId)));

        Bookmark bookmark =
    }*/

}
