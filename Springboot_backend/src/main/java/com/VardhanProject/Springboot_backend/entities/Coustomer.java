package com.VardhanProject.Springboot_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "coustomer")
public class Coustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "coustomer_id", nullable = false,unique = true)
    private Integer coustomer_id;

    @Column(name = "coustomer_name", nullable = false, length = 100)
    private String coustomer_name;

    @Column(name = "coustomer_contact_person", nullable = false, length = 150)
    private String coustomer_contact_person;

    @Column(name = "coustomer_email", nullable = false)
    private String coustomer_email;

    @Column(name = "customer_phone", length = 10)
    @JdbcTypeCode(SqlTypes.NUMERIC)
    private String customer_phone;

    @OneToMany(mappedBy = "coustomer", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<Address> addresses = new LinkedHashSet<>();

}