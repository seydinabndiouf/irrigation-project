package com.digitalfactory.irrigationsystem.models.plotland;

import java.text.MessageFormat;

public enum IrrigationStatus {
    TO_BE_IRRIGATED ("TO_BE_IRRIGATED"),
    IRRIGATED ("IRRIGATED"),
    NOT_IRRIGATED ("NOT_IRRIGATED");

    private String value;

    private IrrigationStatus(String value) {
        this.value = value;
    }

    public static IrrigationStatus fromValue(String value) {
        for (IrrigationStatus irrigationStatus : values()) {
            if (irrigationStatus.value.equalsIgnoreCase(value)) {
                return irrigationStatus;
            }
        }
        throw new IllegalArgumentException(MessageFormat.format("{0} not found with the value: {1} in [{2}]", IrrigationStatus.class, value, values()));
    }
}
