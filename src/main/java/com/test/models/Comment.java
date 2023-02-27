package com.test.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="comments")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String content;

    @NotNull
    @Builder.Default
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime created_at = LocalDateTime.now();

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm")
    @Builder.Default
    @NotNull
    private LocalDateTime updated_at = LocalDateTime.now();

    @ManyToOne
    @JsonIgnore
    private Post post;

}
