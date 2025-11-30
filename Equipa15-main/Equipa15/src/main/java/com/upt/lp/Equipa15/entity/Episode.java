package com.upt.lp.Equipa15.entity;

import jakarta.persistence.*;

@Entity
public class Episode extends Media{
	@ManyToOne
	@JoinColumn(name = "season_id")
	private Season season;
	
	private int duration;
	
	public Episode() {
		
	}
	public Episode(Season season, int duration) {
		super();
		this.season = season;
		this.duration = duration;
	}
	
	//getters and setters
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
}