package org.example.uberreviewservice.Repositories;

import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findById(Long id, String licenceNumber);
    @Query(nativeQuery = true,value ="SELECT * FROM Driver WHERE id=:id AND licence_number=:licenceNumber")
    Optional<Driver> rawfindByIdandLicenceNumber(Long id,String licenceNumber);
}
