package com.example.board.article.dto.request;

import com.example.board.article.entity.ArticleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull
    private ArticleType articleType;
}
