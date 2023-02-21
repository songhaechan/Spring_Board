package com.example.board.article;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Getter
@Entity
@NoArgsConstructor
public class Article {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String content;
    @Enumerated(EnumType.STRING)
    private ArticleType articleType;
    private Integer likeCount = 0;

    @Builder
    public Article(String title, String content, ArticleType articleType) {
        this.title = title;
        this.content = content;
        this.articleType = articleType;
    }

    public Integer addLike(){
        return ++likeCount;
    }

    public Integer cancelLike() {
        if(likeCount < 1){
            throw new LikeCountMinusException();
        }
        return --likeCount;
    }
}
