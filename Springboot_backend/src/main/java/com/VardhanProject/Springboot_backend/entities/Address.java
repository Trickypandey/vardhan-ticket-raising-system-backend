package com.VardhanProject.Springboot_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "address_id", nullable = false)
    private Integer address_id;

    @Column(name = "address_line_1", nullable = false)
    private String address_line1;

    @Column(name = "area", nullable = false, length = 75)
    private String area;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "lat")
    private String lat;

    @Column(name = "longitude")
    private String longitude;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, optional = false)
    @JoinColumn(name = "coustomer_coustomer_id", nullable = false)
    private Coustomer coustomer;

}