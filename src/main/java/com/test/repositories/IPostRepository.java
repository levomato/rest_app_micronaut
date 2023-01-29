package com.test.repositories;

import com.test.models.Post;
import io.micronaut.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Long> {
}
