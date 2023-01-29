package com.test.repositories;

import com.test.models.Post;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
}
