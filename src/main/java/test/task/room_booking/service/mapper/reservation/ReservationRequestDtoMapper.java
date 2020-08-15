package test.task.room_booking.service.mapper.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.task.room_booking.repository.ReservationReasonRepository;
import test.task.room_booking.repository.model.Employee;
import test.task.room_booking.repository.model.Reservation;
import test.task.room_booking.repository.model.ReservationReason;
import test.task.room_booking.repository.model.Room;
import test.task.room_booking.service.dto.request.ReservationRequestDto;
import test.task.room_booking.service.format.FormatHandler;
import test.task.room_booking.service.mapper.EntityMapper;

import java.time.LocalDateTime;

@Component
public class ReservationRequestDtoMapper extends EntityMapper<Reservation, ReservationRequestDto> {

    @Autowired
    private FormatHandler<LocalDateTime> formatter;
    @Autowired
    private ReservationReasonRepository repository;

    @Override
    public Reservation map(ReservationRequestDto objectToMap) {
        ReservationReason reason = repository
                .findByNameAndDescription(
                        objectToMap.getReservationName(),
                        objectToMap.getReservationDescription());
        if (reason == null) {
            reason = ReservationReason.builder()
                    .name(objectToMap.getReservationName())
                    .description(objectToMap.getReservationDescription())
                    .build();
        }
        return Reservation.builder()
                .dateIn(formatter
                        .receiveFormattedDate(objectToMap.getDateIn()))
                .dateOut(formatter
                        .receiveFormattedDate(objectToMap.getDateOut()))
                .employee(Employee.builder()
                        .id(objectToMap.getEmployeeId())
                        .build())
                .room(Room.builder()
                        .id(objectToMap.getRoomId())
                        .build())
                .reservationReason(reason)
                .build();
    }
}
