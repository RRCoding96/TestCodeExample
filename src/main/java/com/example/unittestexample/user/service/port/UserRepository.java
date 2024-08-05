package com.example.unittestexample.user.service.port;

import com.example.unittestexample.user.domain.User;
import com.example.unittestexample.user.domain.UserStatus;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByIdAndStatus(long id, UserStatus userStatus);

    Optional<User> findByEmailAndStatus(String email, UserStatus userStatus);

    User save(User userEntity);

    Optional<User> findById(long id);

    User getById(long id);
}
