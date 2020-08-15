package test.task.room_booking.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import test.task.room_booking.service.dto.detail.ErrorDetails;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String INCORRECT_ENUM_VALUE_EXCEPTION = "IncorrectEnumValueException";
    private static final String RESERVATION_PROCESSING_EXCEPTION = "ReservationProcessingException";
    private static final String NO_SUCH_RECORD_EXCEPTION = "NoSuchRecordException";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ErrorDetails> handleException(RuntimeException e) {
        LocalDateTime currentTime = LocalDateTime.now();
        ErrorDetails errorDetails = new ErrorDetails(currentTime, e.getMessage(), e.toString());
        switch (e.getClass().getSimpleName()) {
            case RESERVATION_PROCESSING_EXCEPTION:
            case INCORRECT_ENUM_VALUE_EXCEPTION:
                return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
            case NO_SUCH_RECORD_EXCEPTION:
                return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
            default:
                return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }
    }

}
