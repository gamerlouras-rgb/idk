package com.upt.lp.Equipa15.Mapping;

import com.upt.lp.Equipa15.DTO.MovieDTO;
import com.upt.lp.Equipa15.entity.Movie;
import com.upt.lp.Equipa15.entity.User;

public class MovieMapper {
    public static MovieDTO toDTO(Movie movie) {
        return new MovieDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getRelease_year(),
                movie.getDuration(),
                movie.getUser() != null ? movie.getUser().getId() : null);
    }

    public static Movie toEntity (MovieDTO dto, User user) {
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        movie.setRelease_year(dto.getReleaseYear());
        movie.setDuration(dto.getDuration());
        movie.setUser(user);
        return movie;
    }
}