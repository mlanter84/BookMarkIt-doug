package com.bookmarkit.service;

import com.bookmarkit.domain.CurrentUser;

/**
 * Created by 580782 on 11/27/2015.
 */
public interface CurrentUserService {
    boolean canAccessUser(CurrentUser currentUser, Long userId);
}
