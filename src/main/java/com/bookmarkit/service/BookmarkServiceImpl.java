package com.bookmarkit.service;

import com.bookmarkit.domain.Bookmark;
import com.bookmarkit.form.BookmarkCreateForm;
import com.bookmarkit.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 580782 on 11/29/2015.
 */

@Service
public class BookmarkServiceImpl implements BookmarkSerivce {

    private final BookmarkRepository bookmarkRepository;

    @Autowired
    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @Override
    public Bookmark create(BookmarkCreateForm form) {
        Bookmark bookmark = new Bookmark();
        bookmark.setUrl(form.getUrl());
        bookmark.setDescription(form.getDescription());
        bookmark.setUser(form.getUser());

        return bookmarkRepository.save(bookmark);
    }
}
