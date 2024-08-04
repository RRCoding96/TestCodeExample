package com.example.unittestexample.post.service.port;

import com.example.unittestexample.post.domain.Post;
import com.example.unittestexample.post.infrastructure.PostEntity;

import java.util.Optional;

public interface PostRepository {
    Optional<Post> findById(long id);

    Post save(Post post);
}
