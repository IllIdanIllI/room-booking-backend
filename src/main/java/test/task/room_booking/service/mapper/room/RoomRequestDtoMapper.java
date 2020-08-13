package test.task.room_booking.service.mapper.room;

import org.springframework.stereotype.Component;
import test.task.room_booking.repository.model.Room;
import test.task.room_booking.repository.model.RoomType;
import test.task.room_booking.repository.model.type.RoomTypeName;
import test.task.room_booking.service.dto.request.RoomRequestDto;
import test.task.room_booking.service.mapper.EntityMapper;

@Component
public class RoomRequestDtoMapper extends EntityMapper<Room, RoomRequestDto> {

    @Override
    public Room map(RoomRequestDto objectToMap) {
        RoomType roomType = RoomType
                .builder()
                .name(RoomTypeName.getValueOf(objectToMap.getType()))
                .build();
        return Room.builder()
                .number(objectToMap.getNumber())
                .type(roomType)
                .build();
    }
}
