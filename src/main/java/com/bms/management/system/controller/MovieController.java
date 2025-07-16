package com.bms.management.system.controller;

import com.bms.management.system.dto.CreateMovieRequestDto;
import com.bms.management.system.model.Movie;
import com.bms.management.system.service.MovieServiceI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private final MovieServiceI movieService;

    //GetMovies
    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {
        // Logic to retrieve a movie by ID
        return movieService.getMovie(id); // Placeholder for actual movie retrieval logic
    }

    @PostMapping
    public Movie createMovie(@RequestBody CreateMovieRequestDto createMovieRequestDto) {
        Movie movie = createMovieRequestDto.toMovie();
        System.out.println("Movie Details : "+movie);
        return movieService.createMovie(movie); // Placeholder for actual movie creation logic
    }
}
