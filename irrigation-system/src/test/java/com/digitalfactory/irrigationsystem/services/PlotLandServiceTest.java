package com.digitalfactory.irrigationsystem.services;

import com.digitalfactory.irrigationsystem.exceptions.SensorDeviceUnavailableException;
import com.digitalfactory.irrigationsystem.models.PlotLand;
import com.digitalfactory.irrigationsystem.models.plotland.AgriculturalCrop;
import com.digitalfactory.irrigationsystem.models.plotland.IrrigationStatus;
import com.digitalfactory.irrigationsystem.models.plotland.PlotLandConfiguration;
import com.digitalfactory.irrigationsystem.services.plotland.AgriculturalCropService;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = {"test"})
@Transactional
public class PlotLandServiceTest {

    @Autowired
    private PlotLandService plotLandService;

    @Autowired
    private AgriculturalCropService agriculturalCropService;

    @Test
    public final void testReadPlotLands() throws Exception {

        /* Getting plotLands */
        Page<PlotLand> plotLands = plotLandService.readPlotLandsByFilters(null, new Date(), PageRequest.of(1, 1));
        Assert.assertNotNull(plotLands);
        Assert.assertEquals("Wrong size of plotLands", 2, plotLands.getTotalElements());
    }

    @Test
    public final void testReadPlotLandByPlotlandId() throws Exception {

        /* Getting plotLands */
        PlotLand plotLand = plotLandService.readPlotLandByPlotLandId(11L);
        Assert.assertNotNull("The plotLand should have been retrieved", plotLand);
    }

    @Test
    public final void testCreatePlotLand() throws Exception {
        /* Getting agriculturalCrop */
        AgriculturalCrop agriculturalCrop = agriculturalCropService.readAgriculturalCropById(11L);

        /* Initializing plotLandConfiguration */
        PlotLandConfiguration plotLandConfiguration = new PlotLandConfiguration();

        /* Setting attributes */
        plotLandConfiguration.setWaterAmount(2000.0);
        plotLandConfiguration.setIrrigationTimeSlot(48);

        /* Initializing plotLand */
        PlotLand plotLand = new PlotLand();

        /* Setting attributes */
        plotLand.setPlotLandArea(1000.0);
        plotLand.setPlotLandName("MyLand");
        plotLand.setAgriculturalCrop(agriculturalCrop);
        plotLand.setPlotLandConfiguration(plotLandConfiguration);

        /* Creating plotLand */
        PlotLand createdPlotLand = plotLandService.createPlotLand(plotLand);

        Assert.assertNotNull("The plotLand should have been created", createdPlotLand);
        Assert.assertNotNull("The next irrigation date should have been set", createdPlotLand.getPlotLandConfiguration().getNextIrrigationDate());
        Assert.assertEquals("The plotLand status should be NOT_IRRIGATED", IrrigationStatus.NOT_IRRIGATED, createdPlotLand.getPlotLandConfiguration().getStatus());
    }

    @Test
    public final void testUpdatePlotLand() throws Exception {
        /*Getting plotland to be updated*/
        PlotLand plotLandToBeUpdated = plotLandService.readPlotLandByPlotLandId(11L);


        /* Getting agriculturalCrop */
        AgriculturalCrop agriculturalCrop = agriculturalCropService.readAgriculturalCropById(11L);

        /* Initializing plotLandConfiguration */
        PlotLandConfiguration plotLandConfiguration = new PlotLandConfiguration();

        /* Setting attributes */
        plotLandConfiguration.setPlotLandId(11L);
        plotLandConfiguration.setWaterAmount(3000.0);
        plotLandConfiguration.setIrrigationTimeSlot(72);

        /* Initializing plotLand */
        PlotLand plotLand = new PlotLand();

        /* Setting attributes */
        plotLand.setPlotLandId(11L);
        plotLand.setPlotLandArea(1000.0);
        plotLand.setPlotLandName("MyLand");
        plotLand.setAgriculturalCrop(agriculturalCrop);
        plotLand.setPlotLandConfiguration(plotLandConfiguration);

        /* Creating plotLand */
        PlotLand updatedPlotLand = plotLandService.updatePlotLand(plotLand);

        Assert.assertNotNull("The plotLand should have been updated", updatedPlotLand);
        Assert.assertNotEquals(plotLandToBeUpdated.getPlotLandConfiguration().getNextIrrigationDate(), updatedPlotLand.getPlotLandConfiguration().getNextIrrigationDate());
    }

    @Test
    public final void testIrrigatePlotland() throws Exception {
        PlotLand plotLandToBeUpdated = plotLandService.readPlotLandByPlotLandId(11L);
        PlotLandConfiguration plotLandConfiguration = plotLandToBeUpdated.getPlotLandConfiguration();

        Date nextIrrigationDateCalculated = DateUtils.addHours(plotLandConfiguration.getNextIrrigationDate(), plotLandConfiguration.getIrrigationTimeSlot());

        /* Irrigate plotland */
        PlotLand plotLand = plotLandService.irrigatePlotLand(11L, true);
        Assert.assertNotNull("The plotLand should have been retrieved", plotLand);
        Assert.assertEquals("The plotLand status have been IRRIGATED", IrrigationStatus.IRRIGATED, plotLand.getPlotLandConfiguration().getStatus());
        Assert.assertEquals("The plotLand next irrigate date", nextIrrigationDateCalculated, plotLand.getPlotLandConfiguration().getNextIrrigationDate());

    }

    public final void testIrrigatePlotlandSensorDeviceUnavailable() throws Exception {
        /* Irrigate plotland with sensor not available */
       PlotLand plotLand = plotLandService.irrigatePlotLand(11L, false);
        Assert.assertEquals("The plotLand status should be not irrigated", IrrigationStatus.NOT_IRRIGATED, plotLand.getPlotLandConfiguration().getStatus());
    }

}
