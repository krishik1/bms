package com.bms.management.system.model;

import com.bms.management.system.enums.Language;
import com.bms.management.system.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;



@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bms_movies")
@Builder
@ToString
public class Movie extends BaseModel{
    private String name;
    private Double rating;
    @OneToMany(mappedBy = "movie")
    private List<Show> shows = new ArrayList<>();


    @ElementCollection
    @Enumerated
    private List<Language> languages = new ArrayList<>();


    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();


}
