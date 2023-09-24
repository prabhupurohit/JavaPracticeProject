package com.pcp.random.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value="/search", produces = "application/vnd.api.v1+json")
public class SearchShowController {

    private final SearchShowService searchShowService;

    public SearchShowController(SearchShowService searchShowService) {
        this.searchShowService = searchShowService;
    }

    @GetMapping("{locationId}/{movieId}/shows")
    public ResponseEntity<ShowDetailsResponse> getOrderByTrackingId(@PathVariable UUID movieId,
                                                                    @PathVariable UUID locationId,
                                                                    @RequestParam Instant showDate) {
        ShowDetailsResponse showDetailsResponse = searchShowService
                .getShowsbyMovieIdAndDate(GetShowsQuery.builder()
                        .movieId(movieId)
                        .showDate(showDate)
                        .locationId(locationId)
                        .build());
        log.info("Returning Shows for location Id: {}, Movie Id: {} and Show Date: {}",
                showDetailsResponse.getLocationId(), showDetailsResponse.getMovieId(), showDetailsResponse.getShowDate());
        return ResponseEntity.ok(showDetailsResponse);
    }
}
