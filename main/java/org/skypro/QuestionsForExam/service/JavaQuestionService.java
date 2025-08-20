package org.skypro.QuestionsForExam.service;

import org.skypro.QuestionsForExam.domain.Question;
import org.skypro.QuestionsForExam.domain.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }
    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;

    }
    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;

    }
    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);

    }
    @Override
    public Question getRandomQuestion() {
        List<String> list = List.of("");
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        String randomElement = list.get(randomIndex);
        System.out.println(randomElement);
        return null;
    }
}