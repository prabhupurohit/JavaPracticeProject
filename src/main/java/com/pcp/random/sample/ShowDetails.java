package com.pcp.random.sample;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ShowDetails {
    private final UUID showId;
    private final UUID movieId;
    private final UUID theatreId;
    private final UUID screenId;
    private final Instant showStartDate;
    private final Instant showEndDate;
    private final Double showDuration;
    private final Integer noOfAvailableSeats;

}
