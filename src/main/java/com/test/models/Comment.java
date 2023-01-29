package com.test.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

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
