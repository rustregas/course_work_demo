package pro.sky.course_work_demo.service;

import org.springframework.stereotype.Service;
import pro.sky.course_work_demo.Question;
import pro.sky.course_work_demo.exceptions.OverFlowRequestException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionServiceImpl javaQuestionServiceImpl;

    public ExaminerServiceImpl(JavaQuestionServiceImpl javaQuestionServiceImpl) {
        this.javaQuestionServiceImpl = javaQuestionServiceImpl;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        if (amount > javaQuestionServiceImpl.getAll().size()) {
            throw new OverFlowRequestException("Слишком большая просьба");
        } else {
            Map<Integer, Question> listExamQuestions = new HashMap<>();
            for (int i = 0; i < amount; i++) {
                Question quest = javaQuestionServiceImpl.getRandomQuestion();
                if (listExamQuestions.containsValue(quest)) {
                    i--;
                } else {
                    listExamQuestions.put(i, quest);
                }
            }
            return List.copyOf(listExamQuestions.values());
        }
    }

}
