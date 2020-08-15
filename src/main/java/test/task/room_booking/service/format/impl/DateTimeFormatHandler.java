package test.task.room_booking.service.format.impl;

import org.springframework.stereotype.Service;
import test.task.room_booking.service.format.FormatHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateTimeFormatHandler implements FormatHandler<LocalDateTime> {

    private static final String COMMON_DATE_PATTERN = "dd/MM/yyyy HH:mm";

    @Override
    public LocalDateTime receiveFormattedDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(COMMON_DATE_PATTERN);
        return LocalDateTime.parse(date, formatter);
    }

    @Override
    public String receiveFormattedDateString(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(COMMON_DATE_PATTERN);
        return date.format(formatter);
    }
}
