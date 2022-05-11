package com.example.assignment2.repositories;

import com.example.assignment2.domain.UnitOfMeasures;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasuresRepository extends CrudRepository<UnitOfMeasures, Long> {
    Optional<UnitOfMeasures> findByDescription(String description);
}
