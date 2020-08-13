package test.task.room_booking.service.dto.response;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class RoomResponseDto implements Serializable {
    private int number;
    private String type;
}
