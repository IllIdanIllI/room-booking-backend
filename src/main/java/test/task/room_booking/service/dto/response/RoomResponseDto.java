package test.task.room_booking.service.dto.response;

import lombok.*;
import org.springframework.data.util.Pair;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class RoomResponseDto implements Serializable {
    private int number;
    private String type;
    private List<Pair<String, String>> dates;
}
