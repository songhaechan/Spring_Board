package com.example.board.article.controller;

import com.example.board.article.dto.request.ArticleRequestDto;
import com.example.board.article.dto.response.ArticleResponseDto;
import com.example.board.article.dto.response.LikeCountResponseDto;
import com.example.board.article.entity.Article;
import com.example.board.article.service.ArticleService;
import com.example.board.article.entity.ArticleType;
import com.example.board.global.IdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/articles") // Request mapping
@RequiredArgsConstructor // final constructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<IdResponse<Long>> saveArticle(@RequestBody ArticleRequestDto article) {
        return ResponseEntity.ok(articleService.saveArticle(article));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponseDto> getArticle(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.getArticle(id));
    }
    //@PathVariable -> URI 에 변수 삽입

    @GetMapping("/all-types")
    public ResponseEntity<List<ArticleResponseDto>> getArticleList(){

        return ResponseEntity.ok(articleService.getArticleList());
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponseDto>> getArticleListByType(@RequestParam ArticleType type){
        return ResponseEntity.ok(articleService.getArticleListByType(type));
    }

    @PostMapping("/{id}/like-count/add")
    public ResponseEntity<LikeCountResponseDto> addLikeCount(@PathVariable Long id){

        return ResponseEntity.ok(articleService.addLikeCount(id));
    }

    @PostMapping("/{id}/like-count/cancel")
    public ResponseEntity<LikeCountResponseDto> cancelLikeCount(@PathVariable Long id){

        return ResponseEntity.ok(articleService.cancelLikeCount(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return ResponseEntity.ok().build();
    }
}
