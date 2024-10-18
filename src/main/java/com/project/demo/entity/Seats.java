package com.project.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name = "seat_details")
public class Seats {
    @Id
    @Column(name = "seat_id")
    private Integer seatId;
    @Column(name = "seat_status")
    private String status;
    @Column(name = "show_id")
    private Integer showId;
    @Column(name = "seat_number")
    private String seatNumber;
    @Column(name = "time_updated")
    @UpdateTimestamp
    private Date lastUpdated;

}
