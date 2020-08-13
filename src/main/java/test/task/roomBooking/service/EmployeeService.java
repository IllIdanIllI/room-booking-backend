package test.task.roomBooking.service;

import test.task.roomBooking.service.dto.request.EmployeeRequestDto;
import test.task.roomBooking.service.dto.response.EmployeeResponseDto;

public interface EmployeeService {

    EmployeeResponseDto findEmployee(int id);

    Integer addEmployee(EmployeeRequestDto dto);
}
