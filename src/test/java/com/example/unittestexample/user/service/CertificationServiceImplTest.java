package com.example.unittestexample.user.service;

import com.example.unittestexample.mock.FakeMailSender;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CertificationServiceImplTest {

    @Test
    public void 이메일과_컨텐츠가_제대로_만들어져서_보내지는지_테스트한다() {
        // given
        FakeMailSender fakeMailSender = new FakeMailSender();
        CertificationServiceImpl certificationServiceImpl = new CertificationServiceImpl(fakeMailSender);

        // when
        certificationServiceImpl.send("kok202@naver.com", 1, "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");

        // then
        assertThat(fakeMailSender.email).isEqualTo("kok202@naver.com");
        assertThat(fakeMailSender.title).isEqualTo("Please certify your email address");
        assertThat(fakeMailSender.content).isEqualTo(
            "Please click the following link to certify your email address: http://localhost:8080/api/users/1/verify?certificationCode=aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");
    }

}