package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Integer> {
    // Display all regions in Canada
    List<Region> findByCountry(String country);

    // Display all regions with country name includes "united"

    List<Region> findByCountryContaining(String country);

    // display all regions with country name includes "united
    List<Region> findByCountryContainsOrderByRegion(String country);


    //Display top two regions in the United States
    List<Region> findTopByCountry(String country);
    List<Region> findTop2ByCountry(String country);
    List<Region> findTop3ByCountry(String country); // limit in sql
    List<Region> findTopByCountryContainsOrderByRegion(String country);



}
