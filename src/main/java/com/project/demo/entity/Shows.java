package com.project.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "shows_table")
public class Shows {
    @Id
    @Column(name = "shows_id")
    private Integer showsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id",nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id",nullable = false)
    private Theatre theatre;

    @Column(name = "show_timings")
    private Date showTimings;

    @Column(name = "available_seats")
    private Integer availableSeats;

}
