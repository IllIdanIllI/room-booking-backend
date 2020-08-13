package test.task.room_booking.repositity.model;

import lombok.*;
import test.task.room_booking.repositity.model.type.EmployeeType;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeIdSequencer")
    @SequenceGenerator(name = "employeeIdSequencer", sequenceName = "employee_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private EmployeeType type;
}
