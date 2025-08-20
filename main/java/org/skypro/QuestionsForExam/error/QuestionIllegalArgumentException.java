package org.skypro.QuestionsForExam.error;

import org.springframework.http.HttpStatus;

public class QuestionIllegalArgumentException extends RuntimeException {
    public QuestionIllegalArgumentException(HttpStatus message) {
        super(String.valueOf(message));
    }
}
