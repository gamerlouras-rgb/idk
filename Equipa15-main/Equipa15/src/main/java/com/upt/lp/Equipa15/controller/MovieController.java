package com.upt.lp.Equipa15.controller;

import com.upt.lp.Equipa15.DTO.MovieDTO;
import com.upt.lp.Equipa15.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(movieService.getMovieById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MovieDTO createMovie(@RequestBody MovieDTO dto) {
        return movieService.createMovie(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> updateMovie(
            @PathVariable Long id,
            @RequestBody MovieDTO dto
    ) {
        try {
            return ResponseEntity.ok(movieService.updateMovie(id, dto));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @GetMapping("/user/{userId}")
    public List<MovieDTO> getMoviesByUser(@PathVariable Long userId) {
        return movieService.getMoviesByUser(userId);
    }

    @GetMapping("/search")
    public List<MovieDTO> searchByTitle(@RequestParam String title) {
        return movieService.searchMoviesByTitle(title);
    }

    @GetMapping("/year/{year}")
    public List<MovieDTO> getMoviesByYear(@PathVariable int year) {
        return movieService.getMoviesByYear(year);
    }

    @GetMapping("/feature-length")
    public List<MovieDTO> getFeatureLengthMovies() {
        return movieService.getFeatureLengthMovies();
    }
}
