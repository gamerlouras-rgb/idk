package com.upt.lp.Equipa15.controller;
import com.upt.lp.Equipa15.DTO.EpisodeDTO;
import com.upt.lp.Equipa15.entity.Episode;
import com.upt.lp.Equipa15.service.EpisodeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.upt.lp.Equipa15.Mapping.EpisodeMapper;

@RestController
@RequestMapping("/api/episodes")
public class EpisodeController {
    private final EpisodeService episodeService;
    
    public EpisodeController(EpisodeService episodeService){
        this.episodeService = episodeService;
    }
    
    @GetMapping
    public List<EpisodeDTO> getAll(){
        return episodeService.getAllEpisodes()
        .stream()
        .map(EpisodeMapper::toDTO)
        .toList();
    }
    
    @GetMapping("/{id}")
    public EpisodeDTO getById(@PathVariable Long id){
        return EpisodeMapper.toDTO(episodeService.getEpisode(id));
    }
    
    @PostMapping
    public EpisodeDTO create(@RequestBody Episode episode){
        return EpisodeMapper.toDTO(episodeService.createEpisode(episode));
    }
    
    @PutMapping("/{id}")
    public EpisodeDTO update(@PathVariable Long id, @RequestBody Episode episode){
        return EpisodeMapper.toDTO(episodeService.updateEpisode(id, episode));
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        episodeService.deleteEpisode(id);
    }

    @GetMapping("/season/{seasonId}")
    public List<EpisodeDTO> getBySeasonId(@PathVariable Long seasonId) {
        return episodeService.getEpisodesBySeasonId(seasonId)
                .stream()
                .map(EpisodeMapper::toDTO)
                .toList();
    }

    @GetMapping("/series/{seriesId}")
    public List<EpisodeDTO> getBySeriesId(@PathVariable Long seriesId) {
        return episodeService.getEpisodesBySeasonSeriesId(seriesId)
                .stream()
                .map(EpisodeMapper::toDTO)
                .toList();
    }
}

