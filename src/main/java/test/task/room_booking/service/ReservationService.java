package test.task.room_booking.service;

import test.task.room_booking.service.dto.request.ReservationRequestDto;

public interface ReservationService {
    void reserveRoom(ReservationRequestDto dto);
}
