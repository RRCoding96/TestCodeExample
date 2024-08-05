package com.example.unittestexample.user.controller.port;

import com.example.unittestexample.user.domain.User;
import com.example.unittestexample.user.domain.UserCreate;
import com.example.unittestexample.user.domain.UserUpdate;

// 이제 안씀
public interface UserService {

    User getByEmail(String email);

    User getById(long id);

    User create(UserCreate userCreate);

    User update(long id, UserUpdate userUpdate);

    void login(long id);

    void verifyEmail(long id, String certificationCode);
}
