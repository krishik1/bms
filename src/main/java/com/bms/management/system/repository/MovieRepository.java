package com.bms.management.system.repository;

import com.bms.management.system.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    /**
     * Finds a movie by its name.
     *
     * @param movieName the name of the movie to find
     * @return an Optional containing the found Movie, or empty if no movie with the given name exists
     */
    Optional<Movie> findByName(String movieName);
}