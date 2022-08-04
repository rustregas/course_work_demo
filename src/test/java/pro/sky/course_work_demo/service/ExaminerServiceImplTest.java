package pro.sky.course_work_demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course_work_demo.Question;
import pro.sky.course_work_demo.exceptions.OverFlowRequestException;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {


    @Mock
    private JavaQuestionServiceImpl javaQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;


    @Test
    void getQuestionsTest() {
        Question question1 = new Question("q1", "a1");

        List<Question> questions = List.of(question1);

        when(javaQuestionServiceMock.getRandomQuestion())
                .thenReturn(question1);
        when(javaQuestionServiceMock.getAll())
                .thenReturn(questions);

        assertEquals(questions, out.getQuestions(1));
    }

    @Test
    void shouldThrowOverFlowRequestExceptionTest() {
        Question question1 = new Question("q1", "a1");

        List<Question> questions = List.of(question1);

        when(javaQuestionServiceMock.getAll())
                .thenReturn(questions);

        assertThrows(OverFlowRequestException.class, () -> out.getQuestions(5));
    }

}