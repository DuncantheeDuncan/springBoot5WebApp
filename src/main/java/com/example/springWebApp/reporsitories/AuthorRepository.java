package com.example.springWebApp.reporsitories;

import com.example.springWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {


}
