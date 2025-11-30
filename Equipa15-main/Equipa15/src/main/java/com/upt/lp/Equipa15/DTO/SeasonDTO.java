package com.upt.lp.Equipa15.DTO;

import java.util.List;

public class SeasonDTO {
	private Long id;
	private String title;
	private String description;
	private Long userId;
	private Long seriesId;
	private int release_year;
	private List<Long> actorIds;
	private List<Long> directorIds;
	private List<Long> reviewIds;
	private List<Long> EpisodeIds;

	public SeasonDTO() {}
	
	public SeasonDTO(Long id, String title, String description, Long userId, Long seriesId, int release_year,
			List<Long> actorIds, List<Long> directorIds, List<Long> reviewIds, List<Long> episodeIds) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.userId = userId;
		this.seriesId = seriesId;
		this.release_year = release_year;
		this.actorIds = actorIds;
		this.directorIds = directorIds;
		this.reviewIds = reviewIds;
		EpisodeIds = episodeIds;
	}

	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public List<Long> getActorIds() {
		return actorIds;
	}

	public void setActorIds(List<Long> actorIds) {
		this.actorIds = actorIds;
	}

	public List<Long> getDirectorIds() {
		return directorIds;
	}

	public void setDirectorIds(List<Long> directorIds) {
		this.directorIds = directorIds;
	}

	public List<Long> getReviewIds() {
		return reviewIds;
	}

	public void setReviewIds(List<Long> reviewIds) {
		this.reviewIds = reviewIds;
	}

	public Long getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Long seriesId) {
		this.seriesId = seriesId;
	}

	public List<Long> getEpisodeIds() {
		return EpisodeIds;
	}

	public void setEpisodeIds(List<Long> episodeIds) {
		EpisodeIds = episodeIds;
	}
	
}