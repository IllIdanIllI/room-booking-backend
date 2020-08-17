package test.task.room_booking.service.mapper.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import test.task.room_booking.repository.model.Reservation;
import test.task.room_booking.service.dto.response.EmployeeReservationResponseDto;
import test.task.room_booking.service.format.FormatHandler;
import test.task.room_booking.service.mapper.EntityMapper;

import java.time.LocalDateTime;

@Component
public class EmployeeReservationResponseDtoMapper extends EntityMapper<EmployeeReservationResponseDto, Reservation> {
    @Autowired
    private FormatHandler<LocalDateTime> formatter;

    @Override
    public EmployeeReservationResponseDto map(Reservation objectToMap) {
        Pair<String, String> dates = Pair
                .of(formatter.receiveFormattedDateString(objectToMap.getDateIn()),
                        formatter.receiveFormattedDateString(objectToMap.getDateOut()));
        return EmployeeReservationResponseDto.builder()
                .id(objectToMap.getId())
                .roomNumber(objectToMap.getRoom().getNumber())
                .reason(objectToMap.getReservationReason().getName())
                .description(objectToMap.getReservationReason().getDescription())
                .dates(dates)
                .build();
    }
}
