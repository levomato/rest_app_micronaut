package com.test.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="posts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String title;

    @NotNull
    private String content;

    @NotNull
    @Builder.Default
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull
    @Builder.Default
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Builder.Default
    private int likes = 0;

    @Builder.Default
    private int dislikes = 0;

    @OneToMany(fetch = FetchType.EAGER, mappedBy= "post", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();
}
