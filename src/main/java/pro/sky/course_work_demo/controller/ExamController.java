package pro.sky.course_work_demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course_work_demo.Question;
import pro.sky.course_work_demo.service.ExaminerServiceImpl;
import pro.sky.course_work_demo.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class ExamController {
    public ExaminerServiceImpl examinerServiceImpl;

    public ExamController(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
    }

    @GetMapping(path = "/getQuestions")
    public Collection<Question> getQuestions(@RequestParam() int amount){
        return examinerServiceImpl.getQuestions(amount);
    }

}
