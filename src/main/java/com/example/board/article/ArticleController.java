package com.example.board.article;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/articles") // Request mapping
@RequiredArgsConstructor // final constructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public Long saveArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable Long id) {
        return articleService.getArticle(id);
    }
    //@PathVariable -> URI 에 변수 삽입

    @GetMapping("/all-types")
    public List<Article> getArticleList(){
        return articleService.getArticleList();
    }

    @GetMapping
    public List<Article> getArticleListByType(@RequestParam ArticleType type){
        return articleService.getArticleListByType(type);
    }

    @PostMapping("/{id}/like-count/add")
    public Integer addLikeCount(@PathVariable Long id){
        return articleService.addLikeCount(id);
    }

    @PostMapping("/{id}/like-count/cancel")
    public Integer cancelLikeCount(@PathVariable Long id){
        return articleService.cancelLikeCount(id);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
    }
}
