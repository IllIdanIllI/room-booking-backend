package test.task.room_booking.service.format;

public interface FormatHandler<T> {
    T receiveFormattedDate(String date);

    String receiveFormattedDateString(T date);
}
