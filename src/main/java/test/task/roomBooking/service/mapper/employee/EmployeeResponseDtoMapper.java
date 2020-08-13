package test.task.roomBooking.service.mapper.employee;

import org.springframework.stereotype.Component;
import test.task.roomBooking.repositity.model.Employee;
import test.task.roomBooking.service.dto.response.EmployeeResponseDto;
import test.task.roomBooking.service.mapper.EntityMapper;

@Component
public class EmployeeResponseDtoMapper extends EntityMapper<EmployeeResponseDto, Employee> {

    @Override
    public EmployeeResponseDto map(Employee objectToMap) {
        return null;
    }
}
