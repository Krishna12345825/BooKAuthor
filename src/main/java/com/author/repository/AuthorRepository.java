package com.author.repository;

import com.author.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    public Author findById(int id);


}
