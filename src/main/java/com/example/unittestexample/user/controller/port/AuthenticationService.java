package com.example.unittestexample.user.controller.port;

import com.example.unittestexample.user.domain.User;
import com.example.unittestexample.user.domain.UserCreate;
import com.example.unittestexample.user.domain.UserUpdate;

public interface AuthenticationService {

    void login(long id);

    void verifyEmail(long id, String certificationCode);
}
