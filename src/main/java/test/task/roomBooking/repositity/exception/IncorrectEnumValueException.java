package test.task.roomBooking.repositity.exception;

public class IncorrectEnumValueException extends RuntimeException {
    public IncorrectEnumValueException() {
        super();
    }

    public IncorrectEnumValueException(String message) {
        super(message);
    }
}
