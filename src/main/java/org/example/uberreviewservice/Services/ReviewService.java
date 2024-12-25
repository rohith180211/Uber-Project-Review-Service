package org.example.uberreviewservice.Services;

import org.example.uberreviewservice.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    public Optional<Review> findReviewById(Long id);

    public List<Review> findAllReviews();

    public Boolean deleteReviewById(Long id);
}