package pro.sky.course_work_demo.service;


import org.springframework.stereotype.Service;
import pro.sky.course_work_demo.Question;

import java.util.Collection;

@Service
public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();

}
