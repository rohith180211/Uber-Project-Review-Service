package org.example.uberreviewservice.Repositories;


import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Driver;
import org.example.uberreviewservice.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository <Review,Long>{

    Integer countAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByCreatedAtBefore(Date date);

    @Query("SELECT R FROM Booking B INNER JOIN Review R where B.id=:bookingId")
    Review findReviewByBookingId(Long bookingId);


}
