package test.task.roomBooking.service;

import test.task.roomBooking.service.dto.request.EmployeeRequestDto;
import test.task.roomBooking.service.dto.response.EmployeeResponseDto;

public interface EmployeeService {

    EmployeeResponseDto findEmployee(int id);

    int addEmployee(EmployeeRequestDto dto);
}
