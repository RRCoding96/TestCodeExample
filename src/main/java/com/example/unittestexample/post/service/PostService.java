package com.example.unittestexample.post.service;

import com.example.unittestexample.common.domain.exception.ResourceNotFoundException;
import com.example.unittestexample.post.domain.Post;
import com.example.unittestexample.post.domain.PostCreate;
import com.example.unittestexample.post.domain.PostUpdate;
import com.example.unittestexample.post.infrastructure.PostEntity;
import com.example.unittestexample.post.infrastructure.PostJpaRepository;
import com.example.unittestexample.post.service.port.PostRepository;
import com.example.unittestexample.user.domain.User;
import com.example.unittestexample.user.infrastructure.UserEntity;
import com.example.unittestexample.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    public Post getById(long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Posts", id));
    }

    public Post create(PostCreate postCreate) {
        User user = userService.getById(postCreate.getWriterId());
        Post post = Post.from(user, postCreate);
        return postRepository.save(post);
    }

    public Post update(long id, PostUpdate postUpdate) {
        Post post = getById(id);
        post = post.update(postUpdate);
        return postRepository.save(post);
    }
}