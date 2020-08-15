package test.task.room_booking.service.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class EmployeeRequestDto implements Serializable {
    @NotBlank(message = "First name have to be filled")
    @Size(max = 50, message = "First name must be less than 50 characters")
    private String firstName;
    @NotBlank(message = "Last name have to be filled")
    @Size(max = 60, message = "Last name must be less than 60 characters")
    private String lastName;
    @NotBlank(message = "Your employee position have to be filled")
    private String type;
}
