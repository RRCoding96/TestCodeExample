package com.example.unittestexample.user.service;

import com.example.unittestexample.common.domain.exception.CertificationCodeNotMatchedException;
import com.example.unittestexample.common.domain.exception.ResourceNotFoundException;
import com.example.unittestexample.common.service.ClockHolder;
import com.example.unittestexample.common.service.UuidHolder;
import com.example.unittestexample.user.domain.User;
import com.example.unittestexample.user.domain.UserStatus;
import com.example.unittestexample.user.domain.UserCreate;
import com.example.unittestexample.user.domain.UserUpdate;
import com.example.unittestexample.user.infrastructure.UserEntity;
import com.example.unittestexample.user.infrastructure.UserJpaRepository;
import com.example.unittestexample.user.service.port.UserRepsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepsitory userRepsitory;
    private final CertificationService certificationService;
    private final UuidHolder uuidHolder;
    private final ClockHolder clockHolder;

    public User getByEmail(String email) {
        return userRepsitory.findByEmailAndStatus(email, UserStatus.ACTIVE)
            .orElseThrow(() -> new ResourceNotFoundException("Users", email));
    }

    public User getById(long id) {
        return userRepsitory.findByIdAndStatus(id, UserStatus.ACTIVE)
            .orElseThrow(() -> new ResourceNotFoundException("Users", id));
    }

    @Transactional
    public User create(UserCreate userCreate) {
        User user = User.from(userCreate, uuidHolder);
        user = userRepsitory.save(user);
        certificationService.send(userCreate.getEmail(), user.getId(), user.getCertificationCode());
        return user;
    }

    @Transactional
    public User update(long id, UserUpdate userUpdate) {
        User user = getById(id);
        user = user.update(userUpdate);
        user = userRepsitory.save(user);
        return user;
    }

    @Transactional
    public void login(long id) {
        User user = userRepsitory.findById(id).orElseThrow(() -> new ResourceNotFoundException("Users", id));
        user = user.login(clockHolder);
        userRepsitory.save(user);
    }

    @Transactional
    public void verifyEmail(long id, String certificationCode) {
        User user = userRepsitory.findById(id).orElseThrow(() -> new ResourceNotFoundException("Users", id));
        user = user.certificate(certificationCode);
        userRepsitory.save(user);
    }

}
