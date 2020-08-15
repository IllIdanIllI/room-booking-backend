package test.task.room_booking.service.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class ReservationRequestDto {
    @NotBlank(message = "Date in have to be filled")
    private String dateIn;
    @NotBlank(message = "Date out have to be filled")
    private String dateOut;
    @NotNull(message = "Room have to be specified")
    private Integer roomId;
    @NotNull(message = "You have to be authorized")
    private Integer employeeId;
    @NotBlank(message = "Reservation name have to be filled")
    @Size(max = 60, message = "Reservation name must be less than 60 characters")
    private String reservationName;
    @Size(max = 1000, message = "Reservation description must be less than 60 characters")
    private String reservationDescription;
}
