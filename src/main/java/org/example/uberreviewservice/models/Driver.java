package org.example.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel {
    private String name;
    @Column(unique = true,nullable = false)
    private String lisenceNumber;
    //1 to many association
    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings=new ArrayList<>();
}
