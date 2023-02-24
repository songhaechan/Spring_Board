package com.example.board.article.exception;

public class LikeCountMinusException extends IllegalStateException {
    private static final String MESSAGE = "좋아요 수는 음수일 수 없습니다.";

    public LikeCountMinusException() {
        super(MESSAGE);
    }
}
