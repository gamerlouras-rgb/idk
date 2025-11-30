package com.upt.lp.Equipa15.DTO;

import java.util.List;

public class SeriesDTO {
	private Long id;
	private String title;
	private String description;
	private Long userId;
	private int release_year;
	private List<Long> actorIds;
	private List<Long> directorIds;
	private List<Long> reviewIds;
	private List<Long> seasonIds;

	public SeriesDTO() {}

	public SeriesDTO(Long id, String title, String description, Long userId, int release_year, List<Long> actorIds,
			List<Long> directorIds, List<Long> reviewIds, List<Long> seasonIds) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.userId = userId;
		this.release_year = release_year;
		this.actorIds = actorIds;
		this.directorIds = directorIds;
		this.reviewIds = reviewIds;
		this.seasonIds = seasonIds;
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

	public List<Long> getSeasonIds() {
		return seasonIds;
	}

	public void setSeasonIds(List<Long> seasonIds) {
		this.seasonIds = seasonIds;
	}
}