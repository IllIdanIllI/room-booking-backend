package test.task.room_booking.service.exception;

public class ReservationProcessingException extends RuntimeException {
    public ReservationProcessingException() {
    }

    public ReservationProcessingException(String message) {
        super(message);
    }
}
