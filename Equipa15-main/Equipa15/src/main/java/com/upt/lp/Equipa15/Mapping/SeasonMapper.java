package com.upt.lp.Equipa15.Mapping;

import java.util.Collections;
import java.util.stream.Collectors;

import com.upt.lp.Equipa15.DTO.SeasonDTO;
import com.upt.lp.Equipa15.entity.Season;

public class SeasonMapper {
    public static SeasonDTO toDTO(Season season) {
        return new SeasonDTO(
        		 season.getId(),
             season.getTitle(),
             season.getDescription(),
             season.getUser() != null ? season.getUser().getId() : null,
             season.getSeries() != null ? season.getSeries().getId() : null,
             season.getRelease_year(),
             season.getActors() != null
             		? season.getActors().stream().map(a -> a.getId()).collect(Collectors.toList())
             		: Collections.emptyList(),
             season.getDirectors() != null
             		? season.getDirectors().stream().map(d -> d.getId()).collect(Collectors.toList())
             		: Collections.emptyList(),
             season.getReviews() != null
             		? season.getReviews().stream().map(r -> r.getId()).collect(Collectors.toList())
             		: Collections.emptyList(),
             season.getEpisodes() != null
                     ? season.getEpisodes().stream().map(e -> e.getId()).collect(Collectors.toList())
                     : Collections.emptyList()
         );
     }      
    
    public static Season toEntity(SeasonDTO dto) {
    		if(dto == null) return null;
    		
    		Season season = new Season();
    		
    		if (dto.getId() != null) {
    			season.setId(dto.getId());
    		}
    		
    		season.setTitle(dto.getTitle());
    		season.setDescription(dto.getDescription());
    		season.setRelease_year(dto.getRelease_year());
    		
    		return season;
    }
}
 
   