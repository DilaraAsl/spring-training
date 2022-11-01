package com.repository;

import com.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
// @ Repository no longer needed in this version of spring
public interface BookRepository extends JpaRepository<Book,Long> {
}
