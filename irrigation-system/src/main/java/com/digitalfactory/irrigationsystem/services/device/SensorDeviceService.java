package com.digitalfactory.irrigationsystem.services.device;

import com.digitalfactory.irrigationsystem.models.device.IrrigationRequest;
import com.digitalfactory.irrigationsystem.models.device.IrrigationResponse;

public interface SensorDeviceService {

    IrrigationResponse irrigate(IrrigationRequest irrigationRequest, boolean available);
}
