package com.project.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "theatre_details")
public class Theatre {
    @Id
    private Integer theatreId;
    @Column(name = "theatre_name")
    private String theatreName;
    @Column(name = "address")
    private String address;
    @Column(name = "pin_code")
    private Integer pinCode;
    @Column(name = "state")
    private String State;

}
