package pro.sky.course_work_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course_work_demo.Question;
import pro.sky.course_work_demo.service.JavaQuestionServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestionController {
    public final JavaQuestionServiceImpl javaQuestionServiceImpl;

    public JavaQuestionController(JavaQuestionServiceImpl javaQuestionServiceImpl) {
        this.javaQuestionServiceImpl = javaQuestionServiceImpl;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam() String question,@RequestParam() String answer){
        return javaQuestionServiceImpl.add(question, answer);
    }

    @GetMapping(path = "/")
    public Collection<Question> getQuestions(){
        return javaQuestionServiceImpl.getAll();
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam() String question, @RequestParam() String answer){
        Question question1 = new Question(question, answer);
        return javaQuestionServiceImpl.remove(question1);
    }

}
