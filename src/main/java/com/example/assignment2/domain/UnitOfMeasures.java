package com.example.assignment2.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class UnitOfMeasures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
}
