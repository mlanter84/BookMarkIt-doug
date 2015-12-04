package com.bookmarkit.service;

import com.bookmarkit.domain.Bookmark;
import com.bookmarkit.form.BookmarkCreateForm;

/**
 * Created by 580782 on 11/29/2015.
 */
public interface BookmarkSerivce {
    Bookmark create(BookmarkCreateForm bookmarkCreateForm);
}
