package test.task.roomBooking.repositity.impl;

import org.springframework.stereotype.Repository;
import test.task.roomBooking.repositity.EmployeeRepository;
import test.task.roomBooking.repositity.model.Employee;

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
