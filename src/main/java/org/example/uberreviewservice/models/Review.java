package org.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bookingReview ")
public class Review extends BaseModel{


    @Column(nullable = false)
    private String content;

    private Double rating;

    @Override
    public String toString() {
        return "Review :" + this.content  + " " + this.rating + " " + this.createdAt;
    }

}
