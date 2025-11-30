package com.upt.lp.Equipa15.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.upt.lp.Equipa15.entity.Episode;
import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long>{
    List<Episode> findBySeasonId(Long seasonId);
    List<Episode> findBySeasonSeriesId(Long seriesId);
}
