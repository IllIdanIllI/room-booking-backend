package test.task.room_booking.service.mapper.employee;

import org.springframework.stereotype.Component;
import test.task.room_booking.repository.model.Employee;
import test.task.room_booking.service.dto.response.EmployeeResponseDto;
import test.task.room_booking.service.mapper.EntityMapper;

@Component
public class EmployeeResponseDtoMapper extends EntityMapper<EmployeeResponseDto, Employee> {

    @Override
    public EmployeeResponseDto map(Employee objectToMap) {
        return null;
    }
}
