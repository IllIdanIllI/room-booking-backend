package test.task.room_booking.repositity.impl;

import org.springframework.stereotype.Repository;
import test.task.room_booking.repositity.EmployeeRepository;
import test.task.room_booking.repositity.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public Employee findEmployee(int id) {
        return null;
    }

    @Override
    public Integer addEmployee(Employee dto) {
        return 0;
    }
}
