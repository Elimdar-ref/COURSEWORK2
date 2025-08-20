package org.skypro.QuestionsForExam.controller;

import org.skypro.QuestionsForExam.domain.Question;
import org.skypro.QuestionsForExam.service.ExaminerService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    public Collection<Question> getQuestions(int amount) {
        return examinerService.getQuestions(amount);
    }
}