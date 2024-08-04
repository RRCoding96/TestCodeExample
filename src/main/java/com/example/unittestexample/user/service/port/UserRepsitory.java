package com.example.unittestexample.user.service.port;

import com.example.unittestexample.user.domain.UserStatus;
import com.example.unittestexample.user.infrastructure.UserEntity;

import java.util.Optional;

public interface UserRepsitory {

    Optional<UserEntity> findByIdAndStatus(long id, UserStatus userStatus);

    Optional<UserEntity> findByEmailAndStatus(String email, UserStatus userStatus);

    UserEntity save(UserEntity userEntity);

    Optional<UserEntity> findById(long id);
}
