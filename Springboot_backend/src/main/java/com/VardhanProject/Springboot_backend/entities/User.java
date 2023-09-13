package com.VardhanProject.Springboot_backend.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uid ;
    private String password;
    private String name ;
    private String role ;
    @Column(length = 10)
    private Integer number;
}

