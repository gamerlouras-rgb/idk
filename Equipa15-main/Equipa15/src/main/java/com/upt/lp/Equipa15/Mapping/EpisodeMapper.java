package com.upt.lp.Equipa15.Mapping;

import java.util.List;
import com.upt.lp.Equipa15.DTO.EpisodeDTO;
import com.upt.lp.Equipa15.entity.Episode;
import com.upt.lp.Equipa15.entity.Season;

public class EpisodeMapper {
    public static EpisodeDTO toDTO(Episode episode) {
        return new EpisodeDTO(
                episode.getId(),
                episode.getTitle( ),
                episode.getDescription(),
                episode.getDuration(),
                episode.getRelease_year(),
                episode.getSeason() != null ? episode.getSeason().getId() : null,
                episode.getSeason() != null && episode.getSeason().getSeries() != null ? episode.getSeason().getSeries().getId() : null
        );
    }

    public static Episode toEntity (EpisodeDTO dto, Season season) {
        Episode episode = new Episode();
        episode.setTitle(dto.getTitle());
        episode.setDescription(dto.getDescription());
        episode.setDuration(dto.getDuration());
        episode.setRelease_year(dto.getRelease_year());
        episode.setSeason(season);
        return episode;
    }  
}
