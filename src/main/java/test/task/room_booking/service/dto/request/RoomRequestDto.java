package test.task.room_booking.service.dto.request;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class RoomRequestDto implements Serializable {
    @Min(value = 0, message = "Room number have to be positive")
    @Max(value = 10000, message = "Too big room number")
    @NotNull(message = "Room number can not be empty")
    private Integer number;
    @NotBlank(message = "Room type have to be filled")
    private String type;
}
