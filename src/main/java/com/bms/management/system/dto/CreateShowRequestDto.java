package com.bms.management.system.dto;

import com.bms.management.system.enums.Language;
import com.bms.management.system.model.Movie;
import com.bms.management.system.model.Screen;
import com.bms.management.system.model.ShowSeat;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CreateShowRequestDto {
    private Long movieId;
    private LocalDate startTime;
    //private Integer duration;
    private Language language;
    private Long screenId;






}
