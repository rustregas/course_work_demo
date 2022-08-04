package pro.sky.course_work_demo.service;

import pro.sky.course_work_demo.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
