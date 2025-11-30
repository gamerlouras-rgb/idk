package com.upt.lp.Equipa15.DTO;
import java.time.LocalDate;
import com.upt.lp.Equipa15.entity.MediaType;
import com.upt.lp.Equipa15.entity.Media;

public class ReviewDTO {
    private Long id;
    private String comment;
    private double rating;
    private LocalDate creationDate;
    private MediaType mediaType;
    private int like_count;
    private Long mediaId;
    private Long userId;

    public ReviewDTO() {}

    public ReviewDTO(Long id, String comment, double rating, LocalDate creationDate, MediaType mediaType, int like_count, Long mediaId, Long userId) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
        this.creationDate = creationDate;
        this.mediaType = mediaType;
        this.like_count = like_count;
        this.mediaId = mediaId;
        this.userId = userId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
