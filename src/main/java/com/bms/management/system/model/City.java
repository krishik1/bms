package com.bms.management.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bms_cities")
public class City extends BaseModel{
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Theatre> theatres = new ArrayList<>();
}
