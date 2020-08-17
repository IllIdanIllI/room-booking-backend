package test.task.room_booking.service;

import test.task.room_booking.service.dto.request.ReservationRequestDto;
import test.task.room_booking.service.dto.response.EmployeeReservationResponseDto;

import java.util.List;

public interface ReservationService {
    Integer reserveRoom(ReservationRequestDto dto);

    void stopReservation(Integer reservationId);

    List<EmployeeReservationResponseDto> getEmployeeReservations(Integer employeeId);
}
