package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity

public class MovieCinema extends BaseEntity {

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate dateTime;


    @ManyToOne(fetch=FetchType.LAZY)// fetch when needed
    private Movie movie;
    @ManyToOne(fetch=FetchType.LAZY)
    private Cinema cinema;

}
