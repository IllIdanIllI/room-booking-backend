package test.task.room_booking.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import test.task.room_booking.service.dto.detail.ErrorDetails;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String INCORRECT_ENUM_VALUE_EXCEPTION = "IncorrectEnumValueException";


    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ErrorDetails> handleException(RuntimeException e) {
        LocalDateTime currentTime = LocalDateTime.now();
        ErrorDetails errorDetails = new ErrorDetails(currentTime, e.getMessage(), e.toString());
        switch (e.getClass().getSimpleName()) {
            case INCORRECT_ENUM_VALUE_EXCEPTION:
                return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
            default:
                return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }
    }

}
