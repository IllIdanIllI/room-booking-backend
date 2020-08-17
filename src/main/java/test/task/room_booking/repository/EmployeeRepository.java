package test.task.room_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import test.task.room_booking.repository.model.Employee;
import test.task.room_booking.repository.model.type.EmployeeType;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Transactional
    Employee findAllByFirstNameAndLastNameAndType(String firstName, String lastName, EmployeeType type);
}
