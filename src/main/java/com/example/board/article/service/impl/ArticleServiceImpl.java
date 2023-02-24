package com.example.board.article.service.impl;

import com.example.board.article.dto.request.ArticleRequestDto;
import com.example.board.article.dto.response.ArticleResponseDto;
import com.example.board.article.dto.response.LikeCountResponseDto;
import com.example.board.article.entity.Article;
import com.example.board.article.mapper.ArticleMapper;
import com.example.board.article.repository.ArticleRepository;
import com.example.board.article.entity.ArticleType;
import com.example.board.article.service.ArticleService;
import com.example.board.global.IdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;
    public IdResponse<Long> saveArticle(ArticleRequestDto article){
        Article entity = articleRepository.save(articleMapper.toEntity(article));
        return new IdResponse<>(entity.getId());
    }

    public ArticleResponseDto getArticle(Long id){

        return articleMapper.toResponseDto(getEntity(id));
    }

    public List<ArticleResponseDto> getArticleList(){

        return articleRepository.findAll().stream()
                .map(articleMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public List<ArticleResponseDto> getArticleListByType(ArticleType articleType){
        return articleRepository.findArticlesByArticleType(articleType).stream()
                .map(articleMapper::toResponseDto)
                .collect(Collectors.toList());
    }
    @Transactional
    public LikeCountResponseDto addLikeCount(Long id){
        return new LikeCountResponseDto(getEntity(id).addLike());
    }
    @Transactional
    public LikeCountResponseDto cancelLikeCount(Long id) {
        return new LikeCountResponseDto(getEntity(id).cancelLike());
    }

    @Transactional
    public void deleteArticle(Long id) {

        getEntity(id).delete();
    }

    private Article getEntity(Long id) {
        return articleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
