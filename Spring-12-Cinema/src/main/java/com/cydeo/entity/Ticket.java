package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
public class Ticket extends BaseEntity{

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate dateTime;
    private int rowNumber;
    private int seatNumber;
    @ManyToOne (fetch=FetchType.LAZY)
    private MovieCinema movieCinema;
    @ManyToOne (fetch=FetchType.LAZY)
    private UserAccount account; // names must match postgres


}
