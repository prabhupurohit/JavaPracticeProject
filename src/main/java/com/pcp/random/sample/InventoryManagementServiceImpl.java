package com.pcp.random.sample;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class InventoryManagementServiceImpl implements InventoryManagementService {

    private final InventoryDataMapper inventoryDataMapper;
    private final InventoryRepository inventoryRepository;

    public InventoryManagementServiceImpl(InventoryDataMapper inventoryDataMapper, InventoryRepository inventoryRepository) {
        this.inventoryDataMapper = inventoryDataMapper;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    @Transactional
    public CreateTheatreResponse createTheatre(CreateTheatreRequest createTheatreRequest) {
        Theatre theatre = inventoryRepository.save(inventoryDataMapper
                .createTheatreRequestToTheatre(createTheatreRequest));
        if (null == theatre) {
            log.warn("Could not create theatre for location id: {}", createTheatreRequest.getLocationId());
            throw new CreateTheatreException("Could not create theatre for location id: " + createTheatreRequest.getLocationId());
        }
        return inventoryDataMapper.theatreToCreateTheatreResponse(theatre);
    }
}
