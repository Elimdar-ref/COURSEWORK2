package org.skypro.QuestionsForExam.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.QuestionsForExam.domain.Question;
import org.skypro.QuestionsForExam.domain.QuestionService;
import org.skypro.QuestionsForExam.error.QuestionIllegalArgumentException;
import org.springframework.http.HttpStatus;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private Set<Question> testQuestions;

    @BeforeEach
    void setUp() {
        testQuestions = new HashSet<>();
        testQuestions.add(new Question("Q1", "A1"));
        testQuestions.add(new Question("Q2", "A2"));
        testQuestions.add(new Question("Q3", "A3"));
        testQuestions.add(new Question("Q4", "A4"));
        testQuestions.add(new Question("Q5", "A5"));
    }

    @Test
    void getQuestions_ValidAmount_ShouldReturnUniqueQuestions() {
        int amount = 3;
        when(questionService.getAllQuestions()).thenReturn(testQuestions);

        when(questionService.getRandomQuestion())
                .thenReturn(new Question("Q1", "A1"))
                .thenReturn(new Question("Q2", "A2"))
                .thenReturn(new Question("Q3", "A3"));

        Collection<Question> result = examinerService.getQuestions(amount);

        assertEquals(amount, result.size());
        assertEquals(amount, new HashSet<>(result).size());
        verify(questionService, times(amount)).getRandomQuestion();
        verify(questionService, times(1)).getAllQuestions();
    }

    @Test
    void getQuestions_AmountGreaterThanTotal_ShouldThrowException() {
        int amount = testQuestions.size() + 1;
        when(questionService.getAllQuestions()).thenReturn(testQuestions);

        QuestionIllegalArgumentException exception = assertThrows(
                QuestionIllegalArgumentException.class,
                () -> examinerService.getQuestions(amount));

        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
        verify(questionService, never()).getRandomQuestion();
    }
}