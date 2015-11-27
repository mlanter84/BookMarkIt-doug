package com.bookmarkit.service;

import com.bookmarkit.domain.CurrentUser;
import com.bookmarkit.domain.Role;
import org.springframework.stereotype.Service;

/**
 * Created by 580782 on 11/27/2015.
 */

@Service
public class CurrentUserServiceImpl implements CurrentUserService {
    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        return currentUser != null
                && (currentUser.getRole()) == Role.ADMIN || currentUser.getId().equals(userId);
    }
}
