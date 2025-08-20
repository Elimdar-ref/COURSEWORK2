package org.skypro.QuestionsForExam.controller;

import org.skypro.QuestionsForExam.domain.Question;
import org.skypro.QuestionsForExam.domain.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/exam/java/add?question=QuestionText&answer=QuestionAnswer")
    public Question addQuestion(String question, String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/exam/java")
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

    @GetMapping("/exam/java/remove?question=QuestionText&answer=QuestionAnswer")
    public Question removeQuestion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return service.remove(newQuestion);
    }
}