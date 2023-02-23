package com.example.board.article;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Getter // Get 메서드 자동생성
@Entity // DB에 Article 클래스 연결
@NoArgsConstructor  // 매개변수 없는 생성자
public class Article {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String content;
    @Enumerated(EnumType.STRING) // entity class 의 속성으로 사용 (Not Ordinary But String)
    private ArticleType articleType;
    private Integer likeCount = 0;

    @Builder // constructor 는 가독성이 떨어질 우려, @builder 은 자동으로 빌더를 생성.
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
} // Article
