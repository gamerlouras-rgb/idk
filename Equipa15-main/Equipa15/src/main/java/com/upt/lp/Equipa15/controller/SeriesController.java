package com.upt.lp.Equipa15.controller;
import com.upt.lp.Equipa15.entity.Season;
import com.upt.lp.Equipa15.entity.Series;
import com.upt.lp.Equipa15.service.SeriesService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/series")
public class SeriesController {
    private final SeriesService seriesService;

    public SeriesController(SeriesService seriesService){
        this.seriesService = seriesService;
    }
    
    @GetMapping
    public List<Series> getAll(){
        return seriesService.getAllSeries();
    }
    
    @GetMapping("/{id}")
    public Series getById(@PathVariable Long id){
        return seriesService.getSeries(id);
    }
    
    @PostMapping
    public Series create(@RequestBody Series series){
        return seriesService.createSeries(series);
    }
    
    @PutMapping("/{id}")
    public Series update(@PathVariable Long id, @RequestBody Series series){
        return seriesService.updateSeries(id, series);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        seriesService.deleteSeries(id);
    }
    
    @PostMapping("/{seriesId}/seasons/{seasontId}") 
    	public Series addSeason(
    			@PathVariable Long seriesId,
    			@PathVariable Long seasonId) {
    		return seriesService.addSeasonToSeries(seriesId, seasonId);
    	}
    
    @GetMapping("/{seriesId}/seasons")
    public List<Season> getSeasonsOfSeries(@PathVariable Long seriesId){
    		return seriesService.getSeasonsOfSeries(seriesId);
    }
    
}

