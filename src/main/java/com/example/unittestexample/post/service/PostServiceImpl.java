package com.example.unittestexample.post.service;

import com.example.unittestexample.common.domain.exception.ResourceNotFoundException;
import com.example.unittestexample.common.service.ClockHolder;
import com.example.unittestexample.post.controller.port.PostService;
import com.example.unittestexample.post.domain.Post;
import com.example.unittestexample.post.domain.PostCreate;
import com.example.unittestexample.post.domain.PostUpdate;
import com.example.unittestexample.post.service.port.PostRepository;
import com.example.unittestexample.user.domain.User;
import com.example.unittestexample.user.service.port.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Builder
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ClockHolder clockHolder;

    @Override
    public Post getById(long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Posts", id));
    }

    @Override
    public Post create(PostCreate postCreate) {
        User user = userRepository.getById(postCreate.getWriterId());
        Post post = Post.from(user, postCreate, clockHolder);
        return postRepository.save(post);
    }

    @Override
    public Post update(long id, PostUpdate postUpdate) {
        Post post = getById(id);
        post = post.update(postUpdate, clockHolder);
        return postRepository.save(post);
    }
}
