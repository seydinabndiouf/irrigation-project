package com.digitalfactory.irrigationsystem.services.iml.device;

import com.digitalfactory.irrigationsystem.exceptions.SensorDeviceUnavailableException;
import com.digitalfactory.irrigationsystem.models.device.IrrigationRequest;
import com.digitalfactory.irrigationsystem.models.device.IrrigationResponse;
import com.digitalfactory.irrigationsystem.models.plotland.IrrigationStatus;
import com.digitalfactory.irrigationsystem.services.device.SensorDeviceService;
import org.springframework.stereotype.Service;

@Service
public class SensorDeviceServiceImpl implements SensorDeviceService {
    @Override
    public IrrigationResponse irrigate(IrrigationRequest irrigationRequest, boolean available) {
        if (!available){
            throw  new SensorDeviceUnavailableException("Sensor device is not available");
        }
        IrrigationResponse irrigationResponse = new IrrigationResponse();
        irrigationResponse.setStatus(IrrigationStatus.IRRIGATED);
        irrigationResponse.setPlotLandId(irrigationRequest.getPlotLandId());
        // Call to sensor here
        return irrigationResponse;
    }
}
