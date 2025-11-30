package com.upt.lp.Equipa15.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Media {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private int release_year;

	@ManyToMany
	@JoinTable(
	name = "media_actor",
	joinColumns = @JoinColumn(name = "media_id"),
	inverseJoinColumns = @JoinColumn(name = "actor_id"))
	private List<Actor> actors = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "media_director",
	joinColumns = @JoinColumn(name = "media_id"),
	inverseJoinColumns = @JoinColumn(name = "director_id"))
	private List<Director> directors = new ArrayList<>();

	@OneToMany(mappedBy = "media", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
	protected Media() {}

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

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addActor(Actor actor) {
		if (actor != null && !this.actors.contains(actor)) {
			this.actors.add(actor);
			if (actor.getMedias() == null) {
				actor.setMedias(new ArrayList<>());
			}
			if (!actor.getMedias().contains(this)) {
				actor.getMedias().add(this);
			}
		}
	}

	public void removeActor(Actor actor) {
		if (actor != null && this.actors.contains(actor)) {
			this.actors.remove(actor);
			actor.getMedias().remove(this);
		}
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public void addDirector(Director director) {
		if (director != null && !this.directors.contains(director)) {
			this.directors.add(director);
			if (director.getMedias() == null) {
				director.setMedias(new ArrayList<>());
			}
			if (!director.getMedias().contains(this)) {
				director.getMedias().add(this);
			}
		}
	}

	public void removeDirector(Director director) {
		if (director != null && this.directors.contains(director)) {
			this.directors.remove(director);
			director.getMedias().remove(this);
		}
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
		review.setMedia(this);
	}

	public void removeReview(Review review) {
		if (review != null && this.reviews.contains(review)) {
			this.reviews.remove(review);
			review.setMedia(null);
		}
	}
}