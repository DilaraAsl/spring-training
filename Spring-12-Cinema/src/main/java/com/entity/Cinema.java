package com.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Cinema extends BaseEntity {


    private String name;
    private String sponsoredName;

    @ManyToOne(fetch = FetchType.LAZY) // a cinema can have multiple locations
    private Location location;

}
