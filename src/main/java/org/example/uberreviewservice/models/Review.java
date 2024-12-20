package org.example.uberreviewservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id //This annotation makes this variable primary key of our table
    Long id;
}
