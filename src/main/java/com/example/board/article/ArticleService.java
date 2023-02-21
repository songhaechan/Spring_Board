package com.example.board.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public Long saveArticle(Article article){
        Article entity = articleRepository.save(article);
        return entity.getId();
    }

    public Article getArticle(Long id){
        return getEntity(id);
    }

    public List<Article> getArticleList(){
        return articleRepository.findAll();
    }

    public List<Article> getArticleListByType(ArticleType articleType){
        return articleRepository.findArticlesByArticleType(articleType);
    }
    @Transactional
    public Integer addLikeCount(Long id){
        return getEntity(id).addLike();
    }
    @Transactional
    public Integer cancelLikeCount(Long id) {
        return getEntity(id).cancelLike();
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    private Article getEntity(Long id) {
        return articleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
