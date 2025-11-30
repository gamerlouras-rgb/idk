package com.upt.lp.Equipa15.controller;
import com.upt.lp.Equipa15.DTO.SeasonDTO;
import com.upt.lp.Equipa15.entity.Season;
import com.upt.lp.Equipa15.entity.Series;
import com.upt.lp.Equipa15.service.SeasonService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/season")
public class SeasonController {
    private final SeasonService seasonService;

    public SeasonController(SeasonService seasonService){
        this.seasonService = seasonService;
    }
    
    @GetMapping
    public List<Season> getAll(){
        return seasonService.getAllSeasons();
    }
    
    @GetMapping("/{id}")
    public Season getById(@PathVariable Long id){
        return seasonService.getSeason(id);
    }
    
    @PostMapping
    public Season create(@RequestBody SeasonDTO season){
        return seasonService.createSeason(season);
    }
    
    @PutMapping("/{id}")
    public Season update(@PathVariable Long id, @RequestBody SeasonDTO season){
        return seasonService.updateSeason(id, season);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        seasonService.deleteSeason(id);
    }
    
    @GetMapping("/{seasonId}/series")
    public Series getSeriesOfSeason(@PathVariable Long seasonId){
    		return seasonService.getSeriesOfSeason(seasonId);
    }
}

