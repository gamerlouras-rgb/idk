package com.upt.lp.Equipa15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.upt.lp.Equipa15.entity.Movie;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByUserId(Long userId);

    List<Movie> findByReleaseYear(int releaseYear);

    List<Movie> findByTitleContainingIgnoreCase(String title);

    List<Movie> findByDurationGreaterThan(int duration);
}
