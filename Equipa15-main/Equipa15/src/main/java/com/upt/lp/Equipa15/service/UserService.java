package com.upt.lp.Equipa15.service;

import com.upt.lp.Equipa15.DTO.UserDTO;
import com.upt.lp.Equipa15.entity.User;
import com.upt.lp.Equipa15.entity.Media;
import com.upt.lp.Equipa15.entity.Series;
import com.upt.lp.Equipa15.entity.Review;
import com.upt.lp.Equipa15.repository.UserRepository;
import com.upt.lp.Equipa15.repository.MediaRepository;
import com.upt.lp.Equipa15.repository.SeriesRepository;
import com.upt.lp.Equipa15.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.upt.lp.Equipa15.entity.UserType;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final MediaRepository mediaRepository;
    private final SeriesRepository seriesRepository;

    public UserService(UserRepository userRepository,ReviewRepository reviewRepository, MediaRepository mediaRepository,SeriesRepository seriesRepository) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.mediaRepository = mediaRepository;
        this.seriesRepository = seriesRepository;
    }

    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    
    public User createUser(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        if (dto.getUserType() != null) {
            try {
                user.setUserType(UserType.valueOf(dto.getUserType().toUpperCase()));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid user type: " + dto.getUserType());
            }
        }

        
        if (dto.getReviewIds() != null && !dto.getReviewIds().isEmpty()) {
            List<Review> reviews = reviewRepository.findAllById(dto.getReviewIds());
            user.setReviews(reviews);
        }

        if (dto.getWatchedMovieIds() != null && !dto.getWatchedMovieIds().isEmpty()) {
            List<Media> movies = mediaRepository.findAllById(dto.getWatchedMovieIds());
            user.setWatched_movies(movies);
        }

        if (dto.getWatchedSeriesIds() != null && !dto.getWatchedSeriesIds().isEmpty()) {
            List<Series> series = seriesRepository.findAllById(dto.getWatchedSeriesIds());
            user.setWatched_series(series);
        }

        return userRepository.save(user);
    }

    
    public User updateUser(Long id, UserDTO dto) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (dto.getUsername() != null) existing.setUsername(dto.getUsername());
        if (dto.getEmail() != null) existing.setEmail(dto.getEmail());
        if (dto.getPassword() != null) existing.setPassword(dto.getPassword());

        if (dto.getUserType() != null) {
            try {
                existing.setUserType(UserType.valueOf(dto.getUserType().toUpperCase()));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid user type: " + dto.getUserType());
            }
        }

        if (dto.getReviewIds() != null) {
            List<Review> reviews = reviewRepository.findAllById(dto.getReviewIds());
            existing.setReviews(reviews);
        }

        if (dto.getWatchedMovieIds() != null) {
            List<Media> movies = mediaRepository.findAllById(dto.getWatchedMovieIds());
            existing.setWatched_movies(movies);
        }

        if (dto.getWatchedSeriesIds() != null) {
            List<Series> series = seriesRepository.findAllById(dto.getWatchedSeriesIds());
            existing.setWatched_series(series);
        }

        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
