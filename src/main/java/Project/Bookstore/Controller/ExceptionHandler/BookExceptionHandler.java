package Project.Bookstore.Controller.ExceptionHandler;

import Project.Bookstore.Controller.BookController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = BookController.class)
public class BookExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidExceptionHandler() {
        return new ResponseEntity<>("모든 값을 입력해야 합니다.", HttpStatus.BAD_REQUEST);
    }
}
