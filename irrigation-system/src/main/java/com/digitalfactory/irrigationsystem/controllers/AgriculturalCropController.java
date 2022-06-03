package com.digitalfactory.irrigationsystem.controllers;

import com.digitalfactory.irrigationsystem.models.plotland.AgriculturalCrop;
import com.digitalfactory.irrigationsystem.services.plotland.AgriculturalCropService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
@Api(value = "/v1")
@Validated
@RequiredArgsConstructor
public class AgriculturalCropController {
    
    private final AgriculturalCropService agriculturalCropService;

    @ApiOperation(value = "Read paginated agriculturalCrop by filters", notes = "Read paginated agriculturalCrop by filters")
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
    @GetMapping(value = "/agriculturalcrops", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<AgriculturalCrop> readAllAgriculturalCrops()
    {
        /* Getting agriculturalCropsList */
        return agriculturalCropService.readAllAgriculturalCrop();
    }
}
