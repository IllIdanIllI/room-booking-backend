package test.task.room_booking.repositity.exception;

public class IncorrectEnumValueException extends RuntimeException {
    public IncorrectEnumValueException() {
        super();
    }

    public IncorrectEnumValueException(String message) {
        super(message);
    }
}
