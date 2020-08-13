package test.task.roomBooking.service.dto.request;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class EmployeeRequestDto implements Serializable {
    private String firstName;
    private String lastName;
    private String type;
}
