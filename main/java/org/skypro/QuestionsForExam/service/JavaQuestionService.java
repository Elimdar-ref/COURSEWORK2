package org.skypro.QuestionsForExam.service;

import org.skypro.QuestionsForExam.domain.Question;
import org.skypro.QuestionsForExam.domain.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    public JavaQuestionService() {
        question();
    }

    private void question() {
        questions.add(new Question("Какой язык программирования вы используете?", "Java"));
        questions.add(new Question("Что такое ООП?", "Объектно-ориентированное программирование"));
        questions.add(new Question("Как работает сортировка пузырьком?", "Алгоритм попарного сравнения элементов"));
        questions.add(new Question("Что такое рекурсия?", "Вызов функцией самой себя"));
        questions.add(new Question("Как использовать HashMap?", "Через put() для добавления и get() для получения"));
    }

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
    public Collection<Question> getAllQuestions() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, questions.size());
        List<Question> questionssList = new ArrayList<>(questions);
        return questionssList.get(randomNumber);
    }
}