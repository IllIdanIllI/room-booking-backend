package test.task.room_booking.repository.exception;

public class IncorrectEnumValueException extends RuntimeException {
    public IncorrectEnumValueException() {
        super();
    }

    public IncorrectEnumValueException(String message) {
        super(message);
    }
}
