package com.upt.lp.Equipa15.service;

import com.upt.lp.Equipa15.DTO.MovieDTO;
import com.upt.lp.Equipa15.entity.Movie;
import com.upt.lp.Equipa15.entity.User;
import com.upt.lp.Equipa15.Mapping.MovieMapper;
import com.upt.lp.Equipa15.repository.MovieRepository;
import com.upt.lp.Equipa15.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class MovieService {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public MovieService(MovieRepository movieRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(MovieMapper::toDTO)
                .toList();
    }

    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        return MovieMapper.toDTO(movie);
    }

    public MovieDTO createMovie(MovieDTO dto) {
        User user = null;

        if (dto.getUserId() != null) {
            user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }

        Movie movie = MovieMapper.toEntity(dto, user);

        return MovieMapper.toDTO(movieRepository.save(movie));
    }

    public MovieDTO updateMovie(Long id, MovieDTO dto) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        movie.setRelease_year(dto.getReleaseYear());
        movie.setDuration(dto.getDuration());

        if (dto.getUserId() != null) {
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            movie.setUser(user);
        }

        return MovieMapper.toDTO(movieRepository.save(movie));
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public List<MovieDTO> getMoviesByUser(Long userId) {
        return movieRepository.findByUserId(userId)
                .stream()
                .map(MovieMapper::toDTO)
                .toList();
    }

    public List<MovieDTO> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title)
                .stream()
                .map(MovieMapper::toDTO)
                .toList();
    }

    public List<MovieDTO> getMoviesByYear(int year) {
        return movieRepository.findByReleaseYear(year)
                .stream()
                .map(MovieMapper::toDTO)
                .toList();
    }

    public List<MovieDTO> getFeatureLengthMovies() {
        return movieRepository.findByDurationGreaterThan(60)
                .stream()
                .map(MovieMapper::toDTO)
                .toList();
    }
}
