package com.example.unittestexample.mock;

import com.example.unittestexample.user.service.port.MailSender;

public class FakeMailSender implements MailSender {

    public String email;
    public String title;
    public String content;

    @Override
    public void send(String email, String title, String content) {
        this.email = email;
        this.title = title;
        this.content = content;
    }
}
