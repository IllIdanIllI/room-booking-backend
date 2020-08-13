package test.task.room_booking.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.room_booking.repositity.EmployeeRepository;
import test.task.room_booking.repositity.model.Employee;
import test.task.room_booking.service.EmployeeService;
import test.task.room_booking.service.dto.request.EmployeeRequestDto;
import test.task.room_booking.service.dto.response.EmployeeResponseDto;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private EntityMapper<EmployeeResponseDto, Employee> responseMapper;
    @Autowired
    private EntityMapper<Employee, EmployeeRequestDto> requestMapper;

    @Override
    public EmployeeResponseDto findEmployee(int id) {
        Employee employee = repository.findEmployee(id);
        return responseMapper.map(employee);
    }

    @Override
    public Integer addEmployee(EmployeeRequestDto dto) {
        Employee employee = requestMapper.map(dto);
        Integer id = repository.addEmployee(employee);
        return Optional.ofNullable(id).orElseThrow();
    }
}
