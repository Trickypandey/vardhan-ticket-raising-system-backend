package com.VardhanProject.Springboot_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id", nullable = false,unique = true)
    private Integer address_id;

    @Column(name = "address_line_1", nullable = false)
    private String address_line_1;

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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}