package com.pcp.random.sample;

import jakarta.validation.Valid;

public interface SearchShowService {
    ShowDetailsResponse getShowsByLocationIdMovieIdAndDate(@Valid GetShowsQuery getShowsQuery);
}
