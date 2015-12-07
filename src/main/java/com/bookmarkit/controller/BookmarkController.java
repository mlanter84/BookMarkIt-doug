package com.bookmarkit.controller;

import com.bookmarkit.domain.Bookmark;
import com.bookmarkit.domain.User;
import com.bookmarkit.form.BookmarkCreateForm;
import com.bookmarkit.service.BookmarkSerivce;
import com.bookmarkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
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

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public Bookmark addBookmark(@PathVariable("userId") Long userId, @RequestBody BookmarkCreateForm form) {

        User user = userService.getUserById(userId)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", userId)));

        form.setUser(user);
        Bookmark bookmark = bookmarkSerivce.create(form);

        return bookmark;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<Bookmark> getBookmarks(@PathVariable("userId") Long userId) {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", userId)));

        return user.getBookmarks().orElse(new ArrayList<>());
    }

/*    @RequestMapping("{userId}/view/{bookmarkId}")
    public Bookmark viewBookmark(@PathVariable("userId") Long userId, @PathVariable("bookmarkId") Long bookmarkId) {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", userId)));

        Bookmark bookmark =
    }*/

}
