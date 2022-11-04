package com.cydeo.repository;

import com.cydeo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
// @ Repository no longer needed in this version of spring
public interface BookRepository extends JpaRepository<Book,Long> {
}
