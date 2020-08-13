package test.task.roomBooking.service.mapper.employee;

import org.springframework.stereotype.Component;
import test.task.roomBooking.repositity.model.Employee;
import test.task.roomBooking.repositity.model.type.EmployeeType;
import test.task.roomBooking.service.dto.request.EmployeeRequestDto;
import test.task.roomBooking.service.mapper.EntityMapper;

@Component
public class EmployeeRequestDtoMapper extends EntityMapper<Employee, EmployeeRequestDto> {

    @Override
    public Employee map(EmployeeRequestDto objectToMap) {
        return Employee.builder()
                .firstName(objectToMap.getFirstName())
                .lastName(objectToMap.getLastName())
                .type(EmployeeType.getValueOf(objectToMap.getType()))
                .build();
    }
}
