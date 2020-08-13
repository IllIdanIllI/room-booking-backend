package test.task.room_booking.repository.model.type;

import test.task.room_booking.repository.exception.IncorrectEnumValueException;

import java.util.Arrays;

public enum RoomTypeName {
    TREATMENT("Treatment room"),
    INTENSIVE("Intensive care room"),
    RECEPTION("Reception room");

    private String type;

    RoomTypeName(String type) {
        this.type = type;
    }

    public String get() {
        return type;
    }

    public static RoomTypeName getValueOf(String type) {
        return Arrays.stream(RoomTypeName.values())
                .filter(enumType -> enumType.get().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new IncorrectEnumValueException("This incorrect room type : \'" + type + "\' - please choose a right one."));
    }
}
