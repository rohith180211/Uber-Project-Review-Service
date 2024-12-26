package org.example.uberreviewservice.Services;

import org.example.uberreviewservice.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    public Optional<Review> getReviewById(Long id);

    public List<Review> getAllReviews();

    public boolean deleteReviewById(Long id);

    public Review publishReview(Review request);

    public Review updateReview(Long reviewId,Review request);
}
