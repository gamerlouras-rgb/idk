package com.upt.lp.Equipa15.controller;

import com.upt.lp.Equipa15.DTO.ReviewDTO;
import com.upt.lp.Equipa15.Mapping.ReviewMapper;
import com.upt.lp.Equipa15.entity.Review;
import com.upt.lp.Equipa15.service.ReviewService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDTO> getAll(){
        return reviewService.getAllReviews()
        .stream()
        .map(ReviewMapper::toDTO)
        .toList();
    }

    @GetMapping("/{id}")
    public ReviewDTO getById(@PathVariable Long id){
        return ReviewMapper.toDTO(reviewService.getReview(id));
    }

    @GetMapping("/movie/{movieId}")
    public List<ReviewDTO> getByMovieId(@PathVariable Long movieId){
        return reviewService.getReviewsByMovieId(movieId)
        .stream()
        .map(ReviewMapper::toDTO)
        .toList();
    }

    @GetMapping("/season/{seasonId}")
    public List<ReviewDTO> getBySeasonId(@PathVariable Long seasonId){
        return reviewService.getReviewsBySeasonId(seasonId)
        .stream()
        .map(ReviewMapper::toDTO)
        .toList();
    }

    @GetMapping("/episode/{episodeId}")
    public List<ReviewDTO> getByEpisodeId(@PathVariable Long episodeId){
        return reviewService.getReviewsByEpisodeId(episodeId);
    }

    @GetMapping("/series/{seriesId}")
    public List<ReviewDTO> getBySeriesId(@PathVariable Long seriesId){
        return reviewService.getReviewsBySeriesId(seriesId)
        .stream()
        .map(ReviewMapper::toDTO)
        .toList();
    }

    @GetMapping("/user/{userId}")
    public List<ReviewDTO> getByUserId(@PathVariable Long userId){
        return reviewService.getReviewsByUserId(userId)
        .stream()
        .map(ReviewMapper::toDTO)
        .toList();
    }

    @PostMapping
    public ReviewDTO create(@RequestBody ReviewDTO reviewDTO){
        return ReviewMapper.toDTO(reviewService.createReviewFromDTO(reviewDTO));
    }

    @PutMapping("/{id}")
    public ReviewDTO update(@PathVariable Long id, @RequestBody Review review){
        return ReviewMapper.toDTO(reviewService.updateReview(id, review));
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        reviewService.deleteReview(id);
    }
}
