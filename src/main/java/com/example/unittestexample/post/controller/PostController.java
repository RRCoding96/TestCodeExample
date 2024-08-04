package com.example.unittestexample.post.controller;

import com.example.unittestexample.post.domain.Post;
import com.example.unittestexample.user.controller.UserController;
import com.example.unittestexample.post.controller.response.PostResponse;
import com.example.unittestexample.post.domain.PostUpdate;
import com.example.unittestexample.post.infrastructure.PostEntity;
import com.example.unittestexample.post.service.PostService;
import com.example.unittestexample.user.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "게시물(posts)")
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable long id) {
        return ResponseEntity
            .ok()
            .body(PostResponse.from(postService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable long id, @RequestBody PostUpdate postUpdate) {
        return ResponseEntity
            .ok()
            .body(PostResponse.from(postService.update(id, postUpdate)));
    }

}
