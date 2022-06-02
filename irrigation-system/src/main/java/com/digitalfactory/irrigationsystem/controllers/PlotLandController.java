package com.digitalfactory.irrigationsystem.controllers;

import com.digitalfactory.irrigationsystem.models.PlotLand;
import com.digitalfactory.irrigationsystem.models.plotland.IrrigationStatus;
import com.digitalfactory.irrigationsystem.models.plotland.PlotLandConfiguration;
import com.digitalfactory.irrigationsystem.services.PlotLandService;
import com.digitalfactory.irrigationsystem.services.plotland.PlotLandConfigurationService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * REST API of Irrigation system for Plot of Land
 *
 * @author seydina
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
@Api(value = "/v1")
@Validated
@RequiredArgsConstructor
public class PlotLandController {

    private final PlotLandService plotLandService;

    private final PlotLandConfigurationService plotLandConfigurationService;

    @ApiOperation(value = "Create PlotLand, if required, the configuration is also created", notes = "Create a plotLand (and potentially the configuration) in the PlotLand Manager")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success"),
            @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
            @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @PostMapping(value = "/plotlands", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PlotLand createPlotLand(
            @ApiParam(value = "PlotLand to create", required = true) @Valid @RequestBody PlotLand plotLand)
    {
        /* Creating plotLand */
        return plotLandService.createPlotLand(plotLand);
    }

    @ApiOperation(value = "Read a plotLand by his identifier", notes = "Read a plotLand in the PlotLand Manager by his identifier")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"), 
            @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
            @ApiResponse(code = 404, message = "Resource access does not exist"), 
            @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/plotlands/{plotLandId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public PlotLand readPlotLandByPlotLandId(
            @ApiParam(value = "PlotLand identifier", required = true, example = "1") @PathVariable("plotLandId") Long plotLandId)
    {
        /* Getting plotLand */
        return plotLandService.readPlotLandByPlotLandId(plotLandId);
    }
    

    @ApiOperation(value = "Read paginated plotLand by filters", notes = "Read paginated plotLand in the PlotLand Manager by filters")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " + "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"), 
            @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
            @ApiResponse(code = 404, message = "Resource access does not exist"), 
            @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @GetMapping(value = "/plotlands", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Page<PlotLand> readPlotLands(
            @ApiParam(value = "excepted irrigation statuses", required = false) @RequestParam(value = "exceptedIrrigationStatuses", required = false) List<IrrigationStatus> exceptedIrrigationStatuses,
            @ApiParam(value = "from nextIrrigationDate", required = false) @RequestParam(value = "fromNextIrrigationDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ") Date fromNextIrrigationDate,
            Pageable pageable)
    {
        /* Getting plotLandsList */
        return plotLandService.readPlotLandsByFilters(exceptedIrrigationStatuses, fromNextIrrigationDate, pageable);
    }

    @ApiOperation(value = "Update a plotLand", notes = "Update a plotLand in the PlotLand Manager")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"), 
            @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
            @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @PutMapping(value = "/plotlands/{plotLandId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public PlotLand updatePlotLand(
            @ApiParam(value = "PlotLand identifier to update",required = true, example = "1") @PathVariable("plotLandId") Long plotLandId,
            @ApiParam(value = "PlotLand to update", required = true) @Valid @RequestBody PlotLand plotLand)
    {
        /* Setting plotLand ID */
        plotLand.setPlotLandId(plotLandId);

        /* Updating plotLand */
        return plotLandService.updatePlotLand(plotLand);
    }


    @ApiOperation(value = "Update plotLand configuration", notes = "Update plotLand configuration in the PlotLand Manager")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "No content"),
        @ApiResponse(code = 400, message = "Request sent by the client was syntactically incorrect"),
        @ApiResponse(code = 500, message = "Internal server error during request processing")})
    @PutMapping(value = "/plotlands/{plotLandId}/configuration", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PlotLandConfiguration updatePlotLandConfiguration(
        @ApiParam(value = "PlotLand configuration to update", required = true, example = "1") @PathVariable("plotLandId") Long plotLandId,
        @Valid @ApiParam(value = "PlotLand configuration to update", required = true) @RequestBody PlotLandConfiguration plotLandConfiguration)
    {
        /* Setting plotLand ID */
        plotLandConfiguration.setPlotLandId(plotLandId);

        /* Updating plotLand configuration */
        return plotLandConfigurationService.updatePlotLandConfiguration(plotLandConfiguration);
    }

}
