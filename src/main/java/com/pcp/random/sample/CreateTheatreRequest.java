package com.pcp.random.sample;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateTheatreRequest {

    @NotNull
    private final String theatreName;
    @NotNull
    private final UUID locationId;
    @NotNull
    private final String type;
    @NotNull
    private final Integer noOfScreens;
    @NotNull
    private final List<ScreenDTO> screens;
}
