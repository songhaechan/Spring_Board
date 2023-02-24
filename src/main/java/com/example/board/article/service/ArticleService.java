package com.example.board.article.service;

import com.example.board.article.dto.request.ArticleRequestDto;
import com.example.board.article.dto.response.ArticleResponseDto;
import com.example.board.article.dto.response.LikeCountResponseDto;
import com.example.board.article.entity.Article;
import com.example.board.article.entity.ArticleType;
import com.example.board.global.IdResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ArticleService {
    IdResponse<Long> saveArticle(ArticleRequestDto article);
    ArticleResponseDto getArticle(Long id);
    List<ArticleResponseDto> getArticleList();
    List<ArticleResponseDto> getArticleListByType(ArticleType articleType);
    LikeCountResponseDto addLikeCount(Long id);
    LikeCountResponseDto cancelLikeCount(Long id);
    void deleteArticle(Long id);
}
