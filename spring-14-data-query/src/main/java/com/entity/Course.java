package com.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@NoArgsConstructor
@Data
@Entity
@Table(name="COURSES")
public class Course extends BaseEntity {
    @Column(name="NAME")
    private String name;
    @Column(name="CATEGORY")
    private String category;
    @Column(name="RATING")
    private int rating;
    @Column(name="DESCRIPTION")
  //  @Column(columnDefinition = "TEXT")
    private String description;


}
