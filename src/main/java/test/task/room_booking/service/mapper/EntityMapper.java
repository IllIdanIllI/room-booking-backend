package test.task.room_booking.service.mapper;

public abstract class EntityMapper<T, N> {

    public abstract T map(N objectToMap);
}
