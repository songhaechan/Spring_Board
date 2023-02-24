package com.example.board.article.mapper;

import com.example.board.article.dto.request.ArticleRequestDto;
import com.example.board.article.dto.response.ArticleResponseDto;
import com.example.board.article.entity.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {
    public Article toEntity (ArticleRequestDto dto) {
        return Article.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .articleType(dto.getArticleType())
                .build();
    }
    public ArticleResponseDto toResponseDto (Article entity){
        return ArticleResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .likeCount(entity.getLikeCount())
                .articleType(entity.getArticleType())
                .build();
    }
}
