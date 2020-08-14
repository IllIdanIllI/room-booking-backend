package test.task.room_booking.service.mapper.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import test.task.room_booking.repository.ReservationRepository;
import test.task.room_booking.repository.model.Reservation;
import test.task.room_booking.repository.model.Room;
import test.task.room_booking.service.dto.response.RoomResponseDto;
import test.task.room_booking.service.mapper.EntityMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomResponseDtoMapper extends EntityMapper<RoomResponseDto, Room> {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public RoomResponseDto map(Room objectToMap) {
        List<Reservation> reservations = reservationRepository
                .findAppropriateReservation(LocalDateTime.now(), objectToMap.getId());
        List<Pair<String, String>> dates = reservations.stream()
                .map(reservation -> Pair
                        .of(reservation.getDateIn().toString(), reservation.getDateOut().toString()))
                .collect(Collectors.toList());
        return RoomResponseDto.builder()
                .number(objectToMap.getNumber())
                .type(objectToMap.getType().getName().get())
                .dates(dates)
                .build();
    }
}
