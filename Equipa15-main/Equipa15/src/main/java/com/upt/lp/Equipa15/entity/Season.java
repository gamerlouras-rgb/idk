package com.upt.lp.Equipa15.entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Season extends Media{
	@ManyToOne
	@JoinColumn(name = "series_id")
	private Series series;
	
	@OneToMany(mappedBy = "season")
	private List<Episode> episodes;
	
	public Season(Series series, List<Episode> episodes) {
		super();
		this.series = series;
		this.episodes = episodes;
	}
	
	public Season() {
		super();
	}

	//getters and setters
	public List<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}
	
	public void addEpisode(Episode episode) {
		if (!this.episodes.contains(episode)) {
			this.episodes.add(episode);
		}
	}
	
	public void removeEpisode(Episode episode) {
	    if (this.episodes != null && this.episodes.contains(episode)) {
	        this.episodes.remove(episode);
	        episode.setSeason(null);
	    }
	}
}