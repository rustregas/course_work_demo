package pro.sky.course_work_demo.service;

import org.junit.jupiter.api.Test;
import pro.sky.course_work_demo.Question;
import pro.sky.course_work_demo.exceptions.QuestionNotFoundException;
import pro.sky.course_work_demo.exceptions.UniqueQuestionException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceImplTest {

    private final JavaQuestionServiceImpl out = new JavaQuestionServiceImpl();

    @Test
    void shouldThrowUniqueQuestionException() {
        out.add("q1", "a1");

        assertThrows(UniqueQuestionException.class, () -> out.add("q1", "a1"));
    }

    @Test
    void testAddStr() {
        Question actualResult = out.add("q1", "a1");
        Question expectedResult = new Question("q1", "a1");

        assertEquals(actualResult, expectedResult);
        assertNotNull(out.getAll());
    }

    @Test
    void testAddQuestion() {

        Question expectedResult = new Question("q1", "a1");
        Question actualResult = out.add(expectedResult);

        assertEquals(actualResult, expectedResult);
        assertNotNull(out.getAll());
    }


    @Test
    void removeTest() {
        Question question = new Question("q1", "a1");
        out.add(question);

        assertEquals(question, out.remove(question));
    }

    @Test
    void shouldThrowQuestionNotFoundException(){
        out.add("q1", "a1");

        Question question = new Question("q999", "a999");

        assertThrows(QuestionNotFoundException.class, () -> out.remove(question));
    }

    @Test
    void getAllTest() {
        Question question = new Question("q999", "a999");

        out.add(question);

        Set<Question> expectedQuestionList = new HashSet<>();
        expectedQuestionList.add(question);

        assertEquals(expectedQuestionList, out.getAll());
    }

    @Test
    void getRandomQuestionTest() {
        Question question1 = new Question("q999", "a999");
        Question question2 = new Question("q1", "a1");
        out.add(question1);
        out.add(question2);
        List<Question> questions = List.of(question1, question2);

        assertTrue(questions.contains(out.getRandomQuestion()));
    }
}