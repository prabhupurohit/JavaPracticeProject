package com.pcp.random.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value="/inventory", produces = "application/vnd.api.v1+json")
public class InventoryManagementController {

    @Autowired
    InventoryManagementService inventoryManagementService;

    @PostMapping("/theatre")
    public ResponseEntity<CreateTheatreResponse> createTheatreResponseEntity(@RequestBody CreateTheatreRequest createTheatreRequest) {
        log.info("Creating theatre for location id: {}", createTheatreRequest.getLocationId());
        CreateTheatreResponse createTheatreResponse = inventoryManagementService.createTheatre(createTheatreRequest);
        log.info("Theatre created with theatre id: {}", createTheatreResponse.getTheatreId());
        return ResponseEntity.ok(createTheatreResponse);
    }
}
