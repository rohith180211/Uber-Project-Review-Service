package org.example.uberreviewservice.Services;

import org.example.uberreviewservice.Repositories.BookingRepository;
import org.example.uberreviewservice.Repositories.DriverRepository;
import org.example.uberreviewservice.Repositories.ReviewRepository;
import org.example.uberreviewservice.models.BaseModel;
import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Driver;
import org.example.uberreviewservice.models.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
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
//        Optional<Booking> b=bookingRepository.findById(6L);
//        if(b.isPresent()){
//            bookingRepository.deleteById(b.get().getId()) ;
//        }
//        Optional<Driver> driver = driverRepository.findById(1L);
//        if(driver.isPresent()) {
//            System.out.println(driver.get().getName());
//                List<Booking> b=driver.get().getBookings();
//                for(Booking bk:b) {
//                    System.out.println(bk.getId());
//                }
//        }
        List<Long> driverIds=new ArrayList<>(Arrays.asList(1L,2L));
        List<Driver> drivers=driverRepository.findAllByIdIn(driverIds);
        //List<Booking> bookings=bookingRepository.findAllByDriverIn(drivers);
//        for(Driver driver:drivers){
//            Set<Booking> bookings=driver.getBookings();
//            bookings.forEach(booking->System.out.println(booking.getId()));
//        }
    }
}
