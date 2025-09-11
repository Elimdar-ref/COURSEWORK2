package org.skypro.QuestionsForExam.controller;

import org.skypro.QuestionsForExam.domain.Question;
import org.skypro.QuestionsForExam.domain.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/questions")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @PostMapping("add")
    public Question addQuestion(String question, String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/exam/java")
    public Collection<Question> getQuestions() {
        return service.getAllQuestions();
    }

    @DeleteMapping("/remove")
    public Question removeQuestion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return service.remove(newQuestion);
    }
}