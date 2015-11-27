package com.bookmarkit.service;

import com.bookmarkit.domain.User;
import com.bookmarkit.form.UserCreateForm;

import java.util.List;
import java.util.Optional;

/**
 * Created by 580782 on 11/25/2015.
 */
public interface UserService {
    Optional<User> getUserById(Long id);

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByEmail(String email);

    List<User> getAllUsers();

    User create(UserCreateForm form);
}
