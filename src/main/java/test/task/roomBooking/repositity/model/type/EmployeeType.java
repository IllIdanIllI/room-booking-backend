package test.task.roomBooking.repositity.model.type;

import test.task.roomBooking.repositity.exception.IncorrectEnumValueException;

import java.util.Arrays;

public enum EmployeeType {
    DOCTOR("doctor"),
    NURSE("nurse"),
    SURGEON("surgeon"),
    THERAPIST("therapist");

    private String type;

    EmployeeType(String type) {
        this.type = type;
    }

    public String get() {
        return type;
    }

    public static EmployeeType getValueOf(String type) {
        return Arrays.stream(EmployeeType.values())
                .filter(enumType -> enumType.get().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new IncorrectEnumValueException("This incorrect employee type : \'" + type + "\' - please choose a right one."));
    }
}
