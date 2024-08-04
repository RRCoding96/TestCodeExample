package com.example.unittestexample.user.infrastructure;

import com.example.unittestexample.user.domain.User;
import com.example.unittestexample.user.domain.UserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "address")
    private String address;

    @Column(name = "certification_code")
    private String certificationCode;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "last_login_at")
    private Long lastLoginAt;

    public static UserEntity fromModel(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.id = user.getId();
        userEntity.email = user.getEmail();
        userEntity.nickname = user.getNickname();
        userEntity.address = user.getAddress();
        userEntity.certificationCode = user.getCertificationCode();
        userEntity.status = user.getStatus();
        userEntity.lastLoginAt = user.getLastLoginAt();
        return userEntity;
    }

    public User toModel() {
        return User.builder()
            .id(this.id)
            .email(this.email)
            .nickname(this.nickname)
            .address(this.address)
            .certificationCode(this.certificationCode)
            .status(this.status)
            .lastLoginAt(this.lastLoginAt)
            .build();
    }
}