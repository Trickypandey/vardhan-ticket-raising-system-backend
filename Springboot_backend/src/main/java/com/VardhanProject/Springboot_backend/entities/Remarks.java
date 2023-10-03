package com.VardhanProject.Springboot_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "remarks")
public class Remarks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User user;

}