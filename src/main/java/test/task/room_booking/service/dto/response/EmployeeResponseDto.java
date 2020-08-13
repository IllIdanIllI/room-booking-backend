package test.task.room_booking.service.dto.response;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class EmployeeResponseDto implements Serializable {
    private String firstName;
    private String lastName;
    private String type;
}
