package test.task.room_booking.service.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class ReservationRequestDto {
    private String dateIn;
    private String dateOut;
    private Integer roomId;
    private Integer employeeId;
    private String reservationName;
    private String reservationDescription;
}
