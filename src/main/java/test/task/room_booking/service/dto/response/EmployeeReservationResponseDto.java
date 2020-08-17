package test.task.room_booking.service.dto.response;

import lombok.*;
import org.springframework.data.util.Pair;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class EmployeeReservationResponseDto implements Serializable {
    private Integer id;
    private int roomNumber;
    private String reason;
    private String description;
    private Pair<String, String> dates;
}
