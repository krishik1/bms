package com.bms.management.system.dto;

import com.bms.management.system.enums.Language;
import com.bms.management.system.enums.MovieFeature;
import com.bms.management.system.model.Movie;
import com.bms.management.system.model.Show;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CreateMovieRequestDto {
    private String name;
    private Double rating;
    private List<Language> languages = new ArrayList<>();
    private List<MovieFeature> features = new ArrayList<>();

    public Movie toMovie() {
        return Movie.builder()
                .name(name)
                .rating(rating)
                .languages(languages)
                .features(features)
                .build();
    }
}
