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
public class CreateTheatreResponse {
    @NotNull
    private final UUID theatreId;
    @NotNull
    private final List<UUID> screenId;
    @NotNull
    private final String message;
}
