package com.pcp.random.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShowRepository extends JpaRepository<Show, UUID> {

    Optional<List<Show>> findByLocationIdMovieIdDate(UUID locationId, UUID movieId, Instant date);

}
