package com.cydeo.repository;

import com.cydeo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;


//@Repository Spring creates an implementation class during run time -that is the reason @Repository works here
// In later versions of spring we no longer need to place @Repository annotation.
public interface CarRepository extends JpaRepository<Car,Long> {
    // if we write a method here in an interface how is it going to be implemented?

}
