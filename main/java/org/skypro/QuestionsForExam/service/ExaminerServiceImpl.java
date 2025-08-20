package org.skypro.QuestionsForExam.service;

import org.skypro.QuestionsForExam.domain.Question;
import org.skypro.QuestionsForExam.domain.QuestionService;
import org.skypro.QuestionsForExam.error.QuestionIllegalArgumentException;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final Random random;

    private final QuestionService questionService;

    public ExaminerServiceImpl(Random random, QuestionService questionService) {
        this.random = random;
        this.questionService = questionService;
        question();
    }

    private void question() {

        Set<String> questions = new HashSet<>();
        questions.add("Какой язык программирования вы используете?");
        questions.add("Что такое ООП?");
        questions.add("Как работает сортировка пузырьком?");
        questions.add("Что такое рекурсия?");
        questions.add("Как использовать HashMap?");

    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new QuestionIllegalArgumentException(BAD_REQUEST);
        }
        return List.of();
    }
}