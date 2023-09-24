package com.pcp.random.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SearchShowServiceImpl implements SearchShowService {
    private final ShowDataMapper showDataMapper;
    private final ShowRepository showRepository;

    public SearchShowServiceImpl(ShowDataMapper showDataMapper, ShowRepository showRepository) {
        this.showDataMapper = showDataMapper;
        this.showRepository = showRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ShowDetailsResponse getShowsbylocationIdMovieIdAndDate(GetShowsQuery getShowsQuery) {
        Optional<List<Show>> showResult = showRepository.findByLocationIdMovieIdDate(getShowsQuery.getLocationId(),
                getShowsQuery.getMovieId(), getShowsQuery.getShowDate());
        if (!showResult.isPresent()) {
            log.warn("Could not find shows with location id: {}, movie id: {} and date: {}",
                    getShowsQuery.getLocationId(), getShowsQuery.getMovieId(), getShowsQuery.getShowDate());
            throw new ShowNotFoundException("Could not find shows with location id: " + getShowsQuery.getLocationId() + ", movie id: " +
                    getShowsQuery.getMovieId() + " and date: " + getShowsQuery.getShowDate());
        }
        return showDataMapper.showToShowDetailsResponse(showResult.get());
    }

}
