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
public class ScreenDTO {

    @NotNull
    private final String type;
    @NotNull
    private final Integer noOfSeats;
    @NotNull
    private final List<SeatDTO> seats;
}
