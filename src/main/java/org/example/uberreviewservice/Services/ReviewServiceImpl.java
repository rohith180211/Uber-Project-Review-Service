package org.example.uberreviewservice.Services;

import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.example.uberreviewservice.models.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Boolean deleteReviewById(Long id) {
        try{
            reviewRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
