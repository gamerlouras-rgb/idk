package com.upt.lp.Equipa15.DTO;

public class EpisodeDTO {
    private Long id;
    private String title;
    private String description;
    private int duration;
    private int release_year;
    private Long seasonId;
    private Long seriesId;

    public EpisodeDTO() {}

    public EpisodeDTO(Long id, String title, String description, int duration, int release_year, Long seasonId, Long seriesId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.release_year = release_year;
        this.seasonId = seasonId;
        this.seriesId = seriesId;
    }

    // Getters and Setters
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public Long getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Long seriesId) {
        this.seriesId = seriesId;
    }
}
