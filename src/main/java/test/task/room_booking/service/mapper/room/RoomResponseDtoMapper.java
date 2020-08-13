package test.task.room_booking.service.mapper.room;

import org.springframework.stereotype.Component;
import test.task.room_booking.repository.model.Employee;
import test.task.room_booking.repository.model.Room;
import test.task.room_booking.service.dto.response.EmployeeResponseDto;
import test.task.room_booking.service.dto.response.RoomResponseDto;
import test.task.room_booking.service.mapper.EntityMapper;

@Component
public class RoomResponseDtoMapper extends EntityMapper<RoomResponseDto, Room> {

    @Override
    public RoomResponseDto map(Room objectToMap) {
        return null;
    }
}
