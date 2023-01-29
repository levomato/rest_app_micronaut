package com.test.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private int Id;

    @NotBlank
    private String content;

    @NotNull
    @Builder.Default
    private LocalDateTime created_at = LocalDateTime.now();

    @NotNull
    private LocalDateTime updated_at = LocalDateTime.now();

    @ManyToOne
    private Post post;

}
