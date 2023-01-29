package com.test.repositories;

import com.test.models.Comment;
import io.micronaut.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment, Long> {
}
