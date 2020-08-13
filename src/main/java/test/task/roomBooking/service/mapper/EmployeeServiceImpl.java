package test.task.roomBooking.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.roomBooking.repositity.EmployeeRepository;
import test.task.roomBooking.repositity.model.Employee;
import test.task.roomBooking.service.EmployeeService;
import test.task.roomBooking.service.dto.request.EmployeeRequestDto;
import test.task.roomBooking.service.dto.response.EmployeeResponseDto;

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
