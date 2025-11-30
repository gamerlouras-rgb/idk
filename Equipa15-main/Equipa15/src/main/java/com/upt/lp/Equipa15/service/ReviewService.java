package com.upt.lp.Equipa15.service;

import com.upt.lp.Equipa15.DTO.ReviewDTO;
import com.upt.lp.Equipa15.entity.*;
import com.upt.lp.Equipa15.repository.*;
import com.upt.lp.Equipa15.Mapping.ReviewMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final SeasonRepository seasonRepository;
    private final EpisodeRepository episodeRepository;
    private final SeriesRepository seriesRepository;

    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository,
                         MovieRepository movieRepository, SeasonRepository seasonRepository,
                         EpisodeRepository episodeRepository, SeriesRepository seriesRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.seasonRepository = seasonRepository;
        this.episodeRepository = episodeRepository;
        this.seriesRepository = seriesRepository;
    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Review getReview(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public Review createReview(Review a) {
        return reviewRepository.save(a);
    }

    public Review updateReview(Long id, Review r) {
        Review existing = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
        existing.setRating(r.getRating());
        existing.setComment(r.getComment());
        existing.setLike_count(r.getLike_count());
        return reviewRepository.save(existing);
    }

    public List<Review> getReviewsByMovieId(Long movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    public List<Review> getReviewsBySeasonId(Long seasonId) {
        return reviewRepository.findBySeasonId(seasonId);
    }

    public List<ReviewDTO> getReviewsByEpisodeId(Long episodeId) {
        return reviewRepository.findByEpisodeId(episodeId)
                .stream()
                .map(ReviewMapper::toDTO)
                .toList();
    }

    public List<Review> getReviewsBySeriesId(Long seriesId) {
        return reviewRepository.findBySeriesId(seriesId);
    }

    public List<Review> getReviewsByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }
    
    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new RuntimeException("Review not found");
        }
        reviewRepository.deleteById(id);
    }

    public Review createReviewFromDTO(ReviewDTO reviewDTO) {
        User user = userRepository.findById(reviewDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Media media = getMediaByIdAndType(reviewDTO.getMediaId(), reviewDTO.getMediaType());
        Review review = ReviewMapper.toEntity(reviewDTO, user, media);
        return reviewRepository.save(review);
    }

    private Media getMediaByIdAndType(Long mediaId, MediaType mediaType) {
        switch (mediaType) {
            case MOVIE:
                return movieRepository.findById(mediaId)
                        .orElseThrow(() -> new RuntimeException("Movie not found"));
            case SERIES:
                return seriesRepository.findById(mediaId)
                        .orElseThrow(() -> new RuntimeException("Series not found"));
            case SEASON:
                return seasonRepository.findById(mediaId)
                        .orElseThrow(() -> new RuntimeException("Season not found"));
            case EPISODE:
                return episodeRepository.findById(mediaId)
                        .orElseThrow(() -> new RuntimeException("Episode not found"));
            default:
                throw new IllegalArgumentException("Invalid media type");
        }
    }


}
