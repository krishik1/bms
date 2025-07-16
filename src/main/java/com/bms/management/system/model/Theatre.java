package com.bms.management.system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bms_theatres")
public class Theatre extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String name;
    private String address;
    @OneToMany
    private List<Screen> screens = new ArrayList<>();


}
