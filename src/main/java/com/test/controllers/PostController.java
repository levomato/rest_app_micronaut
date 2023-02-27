package com.test.controllers;

import com.test.createDtos.CreatePostInput;
import com.test.models.Post;
import com.test.repositories.IPostRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Controller("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final IPostRepository postRepository;

    @io.micronaut.http.annotation.Post
    HttpResponse<?> createPost(@Body CreatePostInput createPostInput) {
        Post post = Post.builder().title(createPostInput.getTitle()).content(createPostInput.getContent()).build();
        postRepository.save(post);
        return HttpResponse.created(post);
    }

    @Get("/")
    HttpResponse<?> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return HttpResponse.ok(posts);
    }

    @Get("/{id}")
    HttpResponse<?> getPostById(@PathVariable Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        return HttpResponse.ok(post);
    }

    @Put("/{id}")
    HttpResponse<?> updatePost(@PathVariable Long id, @Body Map<String, Object> updateParams) {

        Post post = postRepository.findById(id).orElseThrow();
        if(updateParams.containsKey("title")) {
            post.setTitle(updateParams.get("title").toString());
        }
        if(updateParams.containsKey("content")) {
            post.setContent(updateParams.get("content").toString());
        }
        postRepository.update(post);
        return HttpResponse.ok(post);
    }
}
