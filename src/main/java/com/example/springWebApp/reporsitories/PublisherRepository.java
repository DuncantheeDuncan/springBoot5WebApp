package com.example.springWebApp.reporsitories;

import com.example.springWebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
