package com.example.unittestexample.user.controller.port;

import com.example.unittestexample.user.domain.User;
import com.example.unittestexample.user.domain.UserCreate;
import com.example.unittestexample.user.domain.UserUpdate;

public interface UserReadService {

    User getByEmail(String email);

    User getById(long id);

}
