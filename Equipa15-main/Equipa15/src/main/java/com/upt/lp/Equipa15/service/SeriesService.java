package com.upt.lp.Equipa15.service;
import com.upt.lp.Equipa15.entity.Season;
import com.upt.lp.Equipa15.entity.Series;
import com.upt.lp.Equipa15.repository.SeasonRepository;
import com.upt.lp.Equipa15.repository.SeriesRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SeriesService {
    private final SeriesRepository seriesRepository;
    private final SeasonRepository seasonRepository;

    public SeriesService(SeriesRepository seriesRepository, SeasonRepository seasonRepository){
        this.seriesRepository = seriesRepository;
        this.seasonRepository = seasonRepository;
    }
    
    public List<Series> getAllSeries(){
        return seriesRepository.findAll();
    }
    
    public Series getSeries(Long id){
        return seriesRepository.findById(id).orElse(null);
    }
    
    public Series createSeries(Series series) {
        return seriesRepository.save(series);
    }
    
	public Series updateSeries(Long id, Series series){
	    Series existing = seriesRepository.findById(id).orElseThrow(() -> new RuntimeException("Series not found"));
	    existing.setUser(series.getUser());
	    existing.setTitle(series.getTitle());
	    existing.setDescription(series.getDescription());
	    existing.setSeasons(series.getSeasons());
	    existing.setDirectors(series.getDirectors());
	    existing.setActors(series.getActors());
	    existing.setRelease_year(series.getRelease_year());
	    existing.setReviews(series.getReviews());
	
	    return seriesRepository.save(existing);
	   }
	
	public void deleteSeries(Long id){
	    seriesRepository.deleteById(id);
	    }
	
	public Series addSeasonToSeries(Long seriesId, Long seasonId) {
		Series series = seriesRepository.findById(seriesId).orElseThrow(()-> new RuntimeException("Series not found"));
		
		Season season = seasonRepository.findById(seasonId).orElseThrow(()-> new RuntimeException("Season not found"));
		
		season.setSeries(series);
		series.addSeason(season);
		seasonRepository.save(season);
		return seriesRepository.save(series);
	}
	
	public List<Season> getSeasonsOfSeries(Long seriesId){
		Series series = seriesRepository.findById(seriesId).orElseThrow(()-> new RuntimeException("Series not found"));
		return series.getSeasons();
	}
}
