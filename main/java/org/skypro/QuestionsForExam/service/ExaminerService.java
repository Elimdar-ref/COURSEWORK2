package org.skypro.QuestionsForExam.service;

import org.skypro.QuestionsForExam.domain.Question;
import java.util.Collection;

public interface ExaminerService {

    public Collection<Question> getQuestions(int amount);
}