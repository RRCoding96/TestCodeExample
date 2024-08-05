package com.example.unittestexample.mock;

import com.example.unittestexample.common.service.ClockHolder;
import com.example.unittestexample.common.service.UuidHolder;
import com.example.unittestexample.post.controller.PostController;
import com.example.unittestexample.post.controller.PostCreateController;
import com.example.unittestexample.post.controller.port.PostService;
import com.example.unittestexample.post.service.PostServiceImpl;
import com.example.unittestexample.post.service.port.PostRepository;
import com.example.unittestexample.user.controller.UserController;
import com.example.unittestexample.user.controller.UserCreateController;
import com.example.unittestexample.user.service.CertificationServiceImpl;
import com.example.unittestexample.user.service.UserServiceImpl;
import com.example.unittestexample.user.service.port.MailSender;
import com.example.unittestexample.user.service.port.UserRepository;

public class TestContainer {

    public final MailSender mailSender;
    public final UserRepository userRepository;
    public final PostRepository postRepository;
    public final PostService postService;
    public final CertificationServiceImpl certificationService;
    public final UserController userController;
//    public final MyInfoController myInfoController;
    public final UserCreateController userCreateController;
    public final PostController postController;
    public final PostCreateController postCreateController;

//    @Builder
    public TestContainer(ClockHolder clockHolder, UuidHolder uuidHolder) {
        this.mailSender = new FakeMailSender();
        this.userRepository = new FakeUserRepository();
        this.postRepository = new FakePostRepository();
        this.postService = PostServiceImpl.builder()
            .postRepository(this.postRepository)
            .userRepository(this.userRepository)
            .clockHolder(clockHolder)
            .build();
        this.certificationService = new CertificationServiceImpl(this.mailSender);
        UserServiceImpl userService = UserServiceImpl.builder()
            .uuidHolder(uuidHolder)
            .clockHolder(clockHolder)
            .userRepository(this.userRepository)
            .certificationService(this.certificationService)
            .build();
        this.userController = UserController.builder()
            .userService(userService)
            .build();
//        this.myInfoController = MyInfoController.builder()
//            .userService(userService)
//            .build();
        this.userCreateController = UserCreateController.builder()
            .userService(userService)
            .build();
        this.postController = PostController.builder()
            .postService(postService)
            .build();
        this.postCreateController = PostCreateController.builder()
            .postService(postService)
            .build();
    }
}
