package org.skypro.QuestionsForExam.service;

import org.skypro.QuestionsForExam.domain.Question;
import org.skypro.QuestionsForExam.domain.QuestionService;
import org.skypro.QuestionsForExam.error.QuestionIllegalArgumentException;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private Random random;

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> allQuestions = questionService.getAllQuestions();
        if (allQuestions.size() < amount) {
            throw new QuestionIllegalArgumentException(BAD_REQUEST);
        }
        Set<Question> randomQuestions = new HashSet<>();
        while (randomQuestions.size() < amount) {
            Question randomQuestion = questionService.getRandomQuestion();
            randomQuestions.add(randomQuestion);
        }
        return randomQuestions;
    }
}