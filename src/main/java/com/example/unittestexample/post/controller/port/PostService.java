package com.example.unittestexample.post.controller.port;

import com.example.unittestexample.post.domain.Post;
import com.example.unittestexample.post.domain.PostCreate;
import com.example.unittestexample.post.domain.PostUpdate;

public interface PostService {

    Post getById(long id);

    Post create(PostCreate postCreate);

    Post update(long id, PostUpdate postUpdate);
}
