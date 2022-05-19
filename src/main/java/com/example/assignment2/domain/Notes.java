package com.example.assignment2.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(exclude = "recipe")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNote;

}
