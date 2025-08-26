package org.skypro.QuestionsForExam.service;

import org.skypro.QuestionsForExam.domain.Question;
import org.skypro.QuestionsForExam.domain.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
        int randomNumber = ThreadLocalRandom.current().nextInt(0, questions.size());
        List<Question> questionssList = new ArrayList<>(questions);
        return questionssList.get(randomNumber);
    }
}