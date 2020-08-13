package test.task.roomBooking.service.mapper;

import org.springframework.stereotype.Component;

public abstract class EntityMapper<T, N> {

    public abstract T map(N objectToMap);
}
