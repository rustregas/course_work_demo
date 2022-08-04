package pro.sky.course_work_demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UniqueQuestionException extends RuntimeException{
    public UniqueQuestionException(String message) {
        super(message);
    }
}
