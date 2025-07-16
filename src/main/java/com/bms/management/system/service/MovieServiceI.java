package com.bms.management.system.service;

import com.bms.management.system.model.Movie;

public interface MovieServiceI {
    Movie createMovie(Movie movie);

    Movie getMovie(Long id);
}
