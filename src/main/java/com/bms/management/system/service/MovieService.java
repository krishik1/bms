package com.bms.management.system.service;

import com.bms.management.system.exceptions.MovieAlreadyExistsException;
import com.bms.management.system.exceptions.MovieNotFoundException;
import com.bms.management.system.model.Movie;
import com.bms.management.system.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService implements MovieServiceI {
    private final MovieRepository movieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        Optional<Movie> existigMovie = movieRepository.findByName(movie.getName());
        if (existigMovie.isPresent()) {
            throw new MovieAlreadyExistsException(movie.getName());
        }
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovie(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }


}
