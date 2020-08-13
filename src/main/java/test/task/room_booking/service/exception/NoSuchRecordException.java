package test.task.room_booking.service.exception;

public class NoSuchRecordException extends RuntimeException {
    public NoSuchRecordException() {
        super();
    }

    public NoSuchRecordException(String message) {
        super(message);
    }
}
