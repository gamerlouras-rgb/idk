package com.upt.lp.Equipa15.entity;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Series extends Media{
	@OneToMany(mappedBy = "series", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Season> seasons;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Series(List<Season> seasons, User user) {
		super();
		this.seasons = seasons;
	}
	
	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}
	
	public void addSeason(Season season) {
		if (!this.seasons.contains(season)) {
			this.seasons.add(season);
		}
	}
	
	public void removeSeason(Season season) {
	    if (this.seasons != null && this.seasons.contains(season)) {
	        this.seasons.remove(season);
	        season.setSeries(null);
	    }
	}
}