package com.upt.lp.Equipa15.entity;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	private String email;

	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	@OneToMany(mappedBy = "user")
	private List<Review> reviews;
	
	@OneToMany(mappedBy = "user")
	private List<Media> watched_movies;

	@OneToMany(mappedBy = "user")
	private List<Series> watched_series;
	
	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Media> getWatched_movies() {
		return watched_movies;
	}

	public void setWatched_movies(List<Media> watched_movies) {
		this.watched_movies = watched_movies;
	}

	public List<Series> getWatched_series() {
		return watched_series;
	}

	public void setWatched_series(List<Series> watched_series) {
		this.watched_series = watched_series;
	}

    
	public void addWatchedMovie(Media movie) {
		this.watched_movies.add(movie);
		movie.setUser(this);
	}
	public void removeWatchedMovie(Media movie) {
		this.watched_movies.remove(movie);
		movie.setUser(null);
	}
	public void addWatchedSeries(Series series) {
		this.watched_series.add(series);
		series.setUser(this);
	}
	public void removeWatchedSeries(Series series) {
		this.watched_series.remove(series);
		series.setUser(null);
	}
}
