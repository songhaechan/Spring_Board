package com.example.board.article.repository;

import com.example.board.article.entity.Article;
import com.example.board.article.entity.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    List<Article> findArticlesByArticleType(ArticleType articleType);
}
