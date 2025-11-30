package com.upt.lp.Equipa15.service;
import com.upt.lp.Equipa15.entity.Episode;
import com.upt.lp.Equipa15.repository.EpisodeRepository;
import com.upt.lp.Equipa15.Mapping.EpisodeMapper;
import com.upt.lp.Equipa15.DTO.EpisodeDTO;
import com.upt.lp.Equipa15.entity.Season;
import com.upt.lp.Equipa15.repository.SeasonRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EpisodeService {
    private final EpisodeRepository episodeRepository;
    private final SeasonRepository seasonRepository;

    public EpisodeService(EpisodeRepository episodeRepository, SeasonRepository seasonRepository){
        this.episodeRepository = episodeRepository;
        this.seasonRepository = seasonRepository;
    }
    public List<Episode> getAllEpisodes(){
        return episodeRepository.findAll();
    }
    public Episode getEpisode(Long id){
        return episodeRepository.findById(id).orElseThrow(() -> new RuntimeException("Episode not found"));
    }
    public Episode createEpisode(Episode episode) {
        return episodeRepository.save(episode);
    }
    public Episode updateEpisode(Long id, Episode episode){
        Episode existing = episodeRepository.findById(id).orElseThrow(() -> new RuntimeException("Episode not found"));
        existing.setTitle(episode.getTitle());
        existing.setDescription(episode.getDescription());
        existing.setDuration(episode.getDuration());
        existing.setSeason(episode.getSeason());
        existing.setDirectors(episode.getDirectors());
        existing.setSeason(episode.getSeason());
        existing.setActors(episode.getActors());
        existing.setRelease_year(episode.getRelease_year());
        existing.setReviews(episode.getReviews());
        return episodeRepository.save(existing);
    }
    public void deleteEpisode(Long id){
        if (!episodeRepository.existsById(id)) {
            throw new RuntimeException("Episode not found");
        }
        episodeRepository.deleteById(id);
    }   

    public List<Episode> getEpisodesBySeasonId(Long seasonId) {
        return episodeRepository.findBySeasonId(seasonId);
    }
    
    public List<Episode> getEpisodesBySeasonSeriesId(Long seriesId) {
        return episodeRepository.findBySeasonSeriesId(seriesId);
    }

    public Episode createEpisodeFromDTO(EpisodeDTO episodeDTO) {
        Season season = seasonRepository.findById(episodeDTO.getSeasonId())
                .orElseThrow(() -> new RuntimeException("Season not found"));
        Episode episode = EpisodeMapper.toEntity(episodeDTO, season);
        return episodeRepository.save(episode);
    }
}   
