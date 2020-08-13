package test.task.room_booking.service;

import test.task.room_booking.service.dto.request.EmployeeRequestDto;
import test.task.room_booking.service.dto.response.EmployeeResponseDto;

public interface EmployeeService {

    EmployeeResponseDto findEmployee(int id);

    Integer addEmployee(EmployeeRequestDto dto);
}
