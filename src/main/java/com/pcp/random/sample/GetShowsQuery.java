package com.pcp.random.sample;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetShowsQuery {
    private final UUID movieId;
    private final UUID locationId;
    private final Instant showDate;
}
