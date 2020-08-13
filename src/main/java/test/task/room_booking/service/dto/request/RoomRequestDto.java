package test.task.room_booking.service.dto.request;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class RoomRequestDto implements Serializable {
    private int number;
    private String type;
}
