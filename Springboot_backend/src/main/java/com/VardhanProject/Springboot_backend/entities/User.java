package com.VardhanProject.Springboot_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Integer uid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "number", length = 10)
    @JdbcTypeCode(SqlTypes.NUMERIC)
    private String number;

    @Column(name = "user_image")
    @JdbcTypeCode(SqlTypes.BLOB)
    private String user_image;

}