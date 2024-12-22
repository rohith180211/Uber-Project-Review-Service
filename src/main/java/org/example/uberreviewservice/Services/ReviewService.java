package org.example.uberreviewservice.Services;

import org.example.uberreviewservice.Repositories.BookingRepository;
import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        Review r=Review.builder().content("Amazing").rating(4.0).build();
//        Booking b=Booking.builder().review(r).endTime(new Date()).build();
////code to create plain java obj
//
//        bookingRepository.save(b);
//        reviewRepository.save(r);//This code executes sql query
//
//        System.out.println(r);
//        List<Review> reviews=reviewRepository.findAll();
//        for (Review review : reviews) {
//            System.out.println(review.getContent());
//        }
        Optional<Booking> b=bookingRepository.findById(6L);
        if(b.isPresent()){
            bookingRepository.deleteById(b.get().getId()) ;
        }
    }
}
