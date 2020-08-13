package test.task.room_booking.repositity;

import test.task.room_booking.repositity.model.Employee;

public interface EmployeeRepository {

    Employee findEmployee(int id);

    Integer addEmployee(Employee dto);
}
