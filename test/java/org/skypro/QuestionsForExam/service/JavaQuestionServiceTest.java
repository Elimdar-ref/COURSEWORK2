package org.skypro.QuestionsForExam.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.skypro.QuestionsForExam.domain.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


class JavaQuestionServiceTest {

    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
        javaQuestionService.add("Question 1", "Answer 1");
        javaQuestionService.add("Question 2", "Answer 2");
        javaQuestionService.add("Question 3", "Answer 3");
    }

    @Test
    void addWithQuestionObject_ShouldAddQuestion() {
        Question newQuestion = new Question("Test Question", "Test Answer");
        int initialSize = javaQuestionService.getAllQuestions().size();

        Question result = javaQuestionService.add(newQuestion);

        assertEquals(initialSize + 1, javaQuestionService.getAllQuestions().size());
        assertEquals(newQuestion, result);
        assertTrue(javaQuestionService.getAllQuestions().contains(newQuestion));
    }

    @Test
    void remove_ShouldRemoveExistingQuestion() {
        Question questionToRemove = javaQuestionService.getAllQuestions().iterator().next();
        int initialSize = javaQuestionService.getAllQuestions().size();

        Question result = javaQuestionService.remove(questionToRemove);

        assertEquals(initialSize - 1, javaQuestionService.getAllQuestions().size());
        assertEquals(questionToRemove, result);
        assertFalse(javaQuestionService.getAllQuestions().contains(questionToRemove));
    }

    @Test
    void getAllQuestions_ShouldReturnUnmodifiableCollection() {
        Collection<Question> result = javaQuestionService.getAllQuestions();

        assertNotNull(result);
        assertEquals(8, result.size());

        assertThrows(UnsupportedOperationException.class, () -> result.add(new Question("Test", "Test")));

    }

    @Test
    void getRandomQuestion_ShouldReturnQuestionFromCollection() {
        Question result = javaQuestionService.getRandomQuestion();

        assertNotNull(result);
        assertTrue(javaQuestionService.getAllQuestions().contains(result));
    }
}