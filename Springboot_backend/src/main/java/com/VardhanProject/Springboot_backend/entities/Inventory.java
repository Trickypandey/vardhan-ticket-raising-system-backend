package com.VardhanProject.Springboot_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name_of_tool", nullable = false)
    private String name_of_tool;

    @Column(name = "price_of_tool")
    private String price_of_tool;

    @Column(name = "quantity_available")
    private String quantity_available;

}