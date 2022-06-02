package com.digitalfactory.irrigationsystem.exceptions;

public class SensorDeviceUnavailableException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SensorDeviceUnavailableException(String message) {
        super(message);
    }

}
