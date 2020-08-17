package test.task.room_booking.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.room_booking.repository.EmployeeRepository;
import test.task.room_booking.repository.model.Employee;
import test.task.room_booking.repository.model.type.EmployeeType;
import test.task.room_booking.service.EmployeeService;
import test.task.room_booking.service.dto.pagination.PaginationDto;
import test.task.room_booking.service.dto.request.EmployeeRequestDto;
import test.task.room_booking.service.dto.response.EmployeeResponseDto;
import test.task.room_booking.service.exception.NoSuchRecordException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private EntityMapper<EmployeeResponseDto, Employee> responseMapper;
    @Autowired
    private EntityMapper<Employee, EmployeeRequestDto> requestMapper;

    @Override
    public EmployeeResponseDto findModel(Integer id) {
        Optional<Employee> employee = repository.findById(id);
        return responseMapper.map(employee.orElseThrow(() -> new NoSuchRecordException("No such employee")));
    }

    @Override
    public PaginationDto<EmployeeResponseDto> findAllModels(int currentPage, int recordAmount) {
        return null;
    }

    @Override
    public Integer addModel(EmployeeRequestDto dto) {
        Employee employee = requestMapper.map(dto);
        repository.save(employee);
        return Optional.ofNullable(employee.getId()).orElseThrow();
    }

    @Override
    public List<String> getEmployeesTypes() {
        return Arrays.stream(EmployeeType.values())
                .map(EmployeeType::get)
                .collect(Collectors.toList());
    }
}
