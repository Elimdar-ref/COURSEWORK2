package org.skypro.QuestionsForExam.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.skypro.QuestionsForExam.domain.QuestionService;

import static org.junit.jupiter.api.Assertions.*;

class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
    }
}