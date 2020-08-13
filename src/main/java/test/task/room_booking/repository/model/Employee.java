package test.task.room_booking.repository.model;

import lombok.*;
import org.hibernate.annotations.Type;
import test.task.room_booking.repository.model.type.EmployeeType;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
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
    @Enumerated(EnumType.STRING)
    @Type(type = "test.task.room_booking.repository.converter.EmployeeTypeConverter")
    private EmployeeType type;
}
