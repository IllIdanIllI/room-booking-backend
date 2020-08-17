package test.task.room_booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.task.room_booking.repository.EmployeeRepository;
import test.task.room_booking.repository.model.Employee;
import test.task.room_booking.repository.model.type.EmployeeType;
import test.task.room_booking.service.EmployeeService;
import test.task.room_booking.service.dto.pagination.PaginationDto;
import test.task.room_booking.service.dto.request.EmployeeRequestDto;
import test.task.room_booking.service.dto.response.EmployeeResponseDto;
import test.task.room_booking.service.exception.NoSuchRecordException;
import test.task.room_booking.service.mapper.EntityMapper;

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
        Pageable pageable = PageRequest.of(currentPage, recordAmount);
        Page<EmployeeResponseDto> pages = repository.findAll(pageable)
                .map(room -> responseMapper.map(room));
        return new PaginationDto<>(pages.getContent(), pages.getTotalPages());
    }

    @Override
    public Integer addModel(EmployeeRequestDto dto) {
        Employee newEmployee = requestMapper.map(dto);
        Employee oldEmployee = repository.findAllByFirstNameAndLastNameAndType(
                newEmployee.getFirstName(),
                newEmployee.getLastName(),
                newEmployee.getType());
        if (oldEmployee == null) {
            repository.save(newEmployee);
            return Optional.ofNullable(newEmployee.getId()).orElseThrow();
        }
        return Optional.ofNullable(oldEmployee.getId()).orElseThrow();
    }

    @Override
    public List<String> getEmployeesTypes() {
        return Arrays.stream(EmployeeType.values())
                .map(EmployeeType::get)
                .collect(Collectors.toList());
    }
}
