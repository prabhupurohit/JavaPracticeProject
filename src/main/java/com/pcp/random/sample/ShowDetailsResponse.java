package com.pcp.random.sample;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ShowDetailsResponse {

    @NotNull
    private final UUID movieId;
    @NotNull
    private final UUID locationId;
    @NotNull
    private final Instant showDate;
    @NotNull
    private final List<ShowDetails> showDetails;

}
