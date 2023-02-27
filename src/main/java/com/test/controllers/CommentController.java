package com.test.controllers;

import com.test.createDtos.CreateCommentInput;
import com.test.createDtos.CreatePostInput;
import com.test.models.Comment;
import com.test.models.Post;
import com.test.repositories.ICommentRepository;
import com.test.repositories.IPostRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller("api/posts/{id}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final IPostRepository postRepository;
    private final ICommentRepository commentRepository;

    @io.micronaut.http.annotation.Post("/")
    HttpResponse<?> createComment(@PathVariable Long id, @Body CreateCommentInput createCommentInput) {
        Post post = postRepository.findById(id).orElseThrow();
        Comment comment = Comment.builder().content(createCommentInput.getContent()).post(post).build();
        commentRepository.save(comment);
        return HttpResponse.created(comment);
    }

    @Get("/")
    HttpResponse<?> getComments(@PathVariable Long id) {
        List<Comment> comments = commentRepository.findByPostId(id);
        if(comments.isEmpty()) {
            return HttpResponse.noContent();
        }
        return HttpResponse.ok(comments);
    }
}
