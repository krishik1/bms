package com.bms.management.system.model;

import com.bms.management.system.enums.Language;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "bms_shows")
public class Show extends BaseModel{
    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;
    private LocalDate startTime;
    private Integer duration;
    @OneToMany
    private List<ShowSeat> showSeats = new ArrayList<>();
    @ManyToOne
    private Screen screen;
    @Enumerated
    private Language language;
}
