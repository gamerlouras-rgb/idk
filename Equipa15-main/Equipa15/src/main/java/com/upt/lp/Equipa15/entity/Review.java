package com.upt.lp.Equipa15.entity;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double rating;
	private String comment;
	private LocalDate creationDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "media_id")
	private Media media;

	@Enumerated(EnumType.STRING)
	private MediaType mediaType;

	private int like_count;
	
	public Review() {}

	public Review(double rating, String comment, User user, Media media) {
		this.rating = rating;
		this.comment = comment;
		this.creationDate = LocalDate.now();
		this.user = user;
		this.media = media;
		this.like_count = 0;
	}

	//getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		if (rating < 0 || rating > 10) {
			throw new IllegalArgumentException("Rating must be between 0 and 10.");
		}
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		if (comment == null || comment.trim().isEmpty()) {
			throw new IllegalArgumentException("Comment cannot be null or empty.");
		}
		this.comment = comment;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		if (like_count < 0) {
			throw new IllegalArgumentException("Like count cannot be negative.");
		}
		this.like_count = like_count;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	public void incrementLikeCount() {
		this.like_count++;
	}

	public void decrementLikeCount() {
		if (this.like_count > 0) {
			this.like_count--;
		}
	}
}
