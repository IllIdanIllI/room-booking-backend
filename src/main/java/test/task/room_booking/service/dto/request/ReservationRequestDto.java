package test.task.room_booking.service.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class ReservationRequestDto {
    private LocalDateTime dateIn;
    private LocalDateTime dateOut;
    private Integer roomId;
}
