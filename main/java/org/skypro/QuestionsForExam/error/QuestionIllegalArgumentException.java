package org.skypro.QuestionsForExam.error;

import org.springframework.http.HttpStatus;

public class QuestionIllegalArgumentException extends RuntimeException {
    private final HttpStatus status;

    public QuestionIllegalArgumentException(HttpStatus status) {
        super("BAD_REQUEST");
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}