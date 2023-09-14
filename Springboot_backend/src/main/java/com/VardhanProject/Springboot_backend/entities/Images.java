package com.VardhanProject.Springboot_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "images")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "image")
    @JdbcTypeCode(SqlTypes.BLOB)
    private String image;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User user;



}