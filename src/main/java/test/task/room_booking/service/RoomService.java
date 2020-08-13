package test.task.room_booking.service;

import test.task.room_booking.service.dto.request.RoomRequestDto;
import test.task.room_booking.service.dto.response.RoomResponseDto;

public interface RoomService extends CrudService<RoomResponseDto, RoomRequestDto, Integer> {
}
