package org.example.uberreviewservice.Services;

import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.example.uberreviewservice.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Review r=Review.builder().content("Amazing").rating(4.0).build();//code to create plain java obj
        System.out.println(r);
        reviewRepository.save(r);//This code executes sql query
        List<Review> reviews=reviewRepository.findAll();
        for (Review review : reviews) {
            System.out.println(review.getContent());
        }
    }
}
