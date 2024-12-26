package org.example.uberreviewservice.Services;

import jakarta.persistence.EntityNotFoundException;
import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.example.uberreviewservice.models.Review;
import org.hibernate.FetchNotFoundException;
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
    public Optional<Review> getReviewById(Long id) throws EntityNotFoundException {
        Optional<Review> review ;
        try{
            review = reviewRepository.findById(id);
            if(review.isEmpty()){
                throw new EntityNotFoundException("Review with id " + id + " not found");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            if(e.getClass() == EntityNotFoundException.class){
                throw new FetchNotFoundException("Review with id " + id + " not found", id);
            }
            throw new FetchNotFoundException("Unable to fetch, PLease try again later!", id);
        }
        return review;
    }

    @Override
    public List<Review> getAllReviews() {
        return this.reviewRepository.findAll();
    }

    @Override
    public boolean deleteReviewById(Long id) {
        try {
            // Check if the entity exists before deleting
            if (!reviewRepository.existsById(id)) {
                throw new EntityNotFoundException("Review with ID " + id + " not found.");
            }

            // Delete the entity
            reviewRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            // Log the error if needed
            return false;
        }
    }

    @Override
    public Review publishReview(Review request) {
        return this.reviewRepository.save(request);
    }

    @Override
    public Review updateReview(Long reviewId, Review request) {
        Review review = this.reviewRepository.findById(reviewId).orElseThrow(EntityNotFoundException::new);
        if(request.getRating()!=null){
            review.setRating(request.getRating());
        }
        if(request.getContent()!=null){
            review.setContent(request.getContent());
        }
        return this.reviewRepository.save(review);
    }
}
