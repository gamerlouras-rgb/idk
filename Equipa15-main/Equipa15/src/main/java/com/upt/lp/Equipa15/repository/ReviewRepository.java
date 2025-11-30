package com.upt.lp.Equipa15.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.upt.lp.Equipa15.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    List<Review> findByMovieId(Long movieId);
    List<Review> findBySeasonId(Long seasonId);
    List<Review> findByEpisodeId(Long episodeId);
    List<Review> findBySeriesId(Long seriesId);
    List<Review> findByUserId(Long userId);
}
