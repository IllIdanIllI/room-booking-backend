package test.task.room_booking.service.dto.pagination;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class PaginationDto<T> {
    private List<T> models;
    private Integer totalPages;
}
