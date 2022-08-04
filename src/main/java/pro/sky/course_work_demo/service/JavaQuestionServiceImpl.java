package pro.sky.course_work_demo.service;

import org.springframework.stereotype.Service;
import pro.sky.course_work_demo.Question;
import pro.sky.course_work_demo.exceptions.QuestionNotFoundException;
import pro.sky.course_work_demo.exceptions.UniqueQuestionException;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private Set<Question> questionList;
    final Random random = new Random();

    public JavaQuestionServiceImpl() {
        this.questionList = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question quest = new Question(question, answer);

        if (questionList.contains(quest)) {
            throw new UniqueQuestionException("Данный вопрос уже есть");
        } else {
            questionList.add(quest);
            return quest;
        }
    }

    @Override
    public Question add(Question question) {
        if (questionList.contains(question)) {
            throw new UniqueQuestionException("Данный вопрос уже есть");
        } else {
            questionList.add(question);
            return question;
        }
    }

    @Override
    public Question remove(Question question) {
        if (questionList.contains(question)) {
            questionList.remove(question);
            return question;
        } else {
            throw new QuestionNotFoundException("Нет такого вопроса");
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(questionList);
    }

    @Override
    public Question getRandomQuestion() {
        int number = random.nextInt(questionList.size());
        return List.copyOf(questionList).get(number);
    }
}
