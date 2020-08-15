package test.task.room_booking.service;

import test.task.room_booking.service.dto.request.ReservationRequestDto;

public interface ReservationService {
    Integer reserveRoom(ReservationRequestDto dto);

    void stopReservation(Integer reservationId);
}
