package test.task.roomBooking.repositity;

import test.task.roomBooking.repositity.model.Employee;

public interface EmployeeRepository {

    Employee findEmployee(int id);

    Integer addEmployee(Employee dto);
}
