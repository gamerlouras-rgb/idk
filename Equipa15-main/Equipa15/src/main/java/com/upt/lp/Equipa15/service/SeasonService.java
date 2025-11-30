package com.upt.lp.Equipa15.service;
import com.upt.lp.Equipa15.DTO.SeasonDTO;
import com.upt.lp.Equipa15.Mapping.SeasonMapper;
import com.upt.lp.Equipa15.entity.Actor;
import com.upt.lp.Equipa15.entity.Director;
import com.upt.lp.Equipa15.entity.Episode;
import com.upt.lp.Equipa15.entity.Review;
import com.upt.lp.Equipa15.entity.Season;
import com.upt.lp.Equipa15.entity.Series;
import com.upt.lp.Equipa15.entity.User;
import com.upt.lp.Equipa15.repository.ActorRepository;
import com.upt.lp.Equipa15.repository.DirectorRepository;
import com.upt.lp.Equipa15.repository.EpisodeRepository;
import com.upt.lp.Equipa15.repository.ReviewRepository;
import com.upt.lp.Equipa15.repository.SeasonRepository;
import com.upt.lp.Equipa15.repository.SeriesRepository;
import com.upt.lp.Equipa15.repository.UserRepository;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SeasonService {
    private final SeasonRepository seasonRepository;
    private final SeriesRepository seriesRepository;
    private final UserRepository userRepository;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final ReviewRepository reviewRepository;
    private final EpisodeRepository episodeRepository;

    public SeasonService(
            SeasonRepository seasonRepository,
            SeriesRepository seriesRepository,
            UserRepository userRepository,
            ActorRepository actorRepository,
            DirectorRepository directorRepository,
            ReviewRepository reviewRepository,
            EpisodeRepository episodeRepository) 
    {
        this.seasonRepository = seasonRepository;
        this.seriesRepository = seriesRepository;
        this.userRepository = userRepository;
        this.actorRepository = actorRepository;
        this.directorRepository = directorRepository;
        this.reviewRepository = reviewRepository;
        this.episodeRepository = episodeRepository;
    }
    
    public List<Season> getAllSeasons(){
        return seasonRepository.findAll();
    }
    
    public Season getSeason(Long id){
        return seasonRepository.findById(id).orElse(null);
    }
    
    public Season createSeason(SeasonDTO dto) {
        Season season = SeasonMapper.toEntity(dto);
        
        if (dto.getSeriesId() != null) {
            Series series = seriesRepository.findById(dto.getSeriesId())
                    .orElseThrow(() -> new RuntimeException("Series not found"));
            season.setSeries(series);
        }

        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            season.setUser(user);
        }

        if (dto.getActorIds() != null && !dto.getActorIds().isEmpty()) {
            List<Actor> actors = actorRepository.findAllById(dto.getActorIds());
            season.setActors(actors);
        }

        if (dto.getDirectorIds() != null && !dto.getDirectorIds().isEmpty()) {
            List<Director> directors = directorRepository.findAllById(dto.getDirectorIds());
            season.setDirectors(directors);
        }

        if (dto.getReviewIds() != null && !dto.getReviewIds().isEmpty()) {
            List<Review> reviews = reviewRepository.findAllById(dto.getReviewIds());
            season.setReviews(reviews);
        }
        
        if (dto.getEpisodeIds() != null && !dto.getEpisodeIds().isEmpty()) {
            List<Episode> episodes = episodeRepository.findAllById(dto.getEpisodeIds());
            season.setEpisodes(episodes);
        }

        return seasonRepository.save(season);
    }

    public Season updateSeason(Long id, SeasonDTO dto) {
        Season existing = getSeason(id);

        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setRelease_year(dto.getRelease_year());

        if (dto.getSeriesId() != null) {
            Series series = seriesRepository.findById(dto.getSeriesId())
                    .orElseThrow(() -> new RuntimeException("Series not found"));
            existing.setSeries(series);
        }

        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            existing.setUser(user);
        }

        if (dto.getActorIds() != null) {
            List<Actor> actors = actorRepository.findAllById(dto.getActorIds());
            existing.setActors(actors);
        }

        if (dto.getDirectorIds() != null) {
            List<Director> directors = directorRepository.findAllById(dto.getDirectorIds());
            existing.setDirectors(directors);
        }

        if (dto.getReviewIds() != null) {
            List<Review> reviews = reviewRepository.findAllById(dto.getReviewIds());
            existing.setReviews(reviews);
        }

        if (dto.getEpisodeIds() != null) {
            List<Episode> episodes = episodeRepository.findAllById(dto.getEpisodeIds());
            existing.setEpisodes(episodes);
        }

        return seasonRepository.save(existing);
    }
	
	public void deleteSeason(Long id){
	    seasonRepository.deleteById(id);
	    }
	
	public Series getSeriesOfSeason(Long seasonId){
		Season season = seasonRepository.findById(seasonId).orElseThrow(()-> new RuntimeException("Season not found"));
		return season.getSeries();
	}
}
