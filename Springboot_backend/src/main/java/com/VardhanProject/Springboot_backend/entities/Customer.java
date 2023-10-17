package com.VardhanProject.Springboot_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", nullable = false,unique = true)
    private Integer customer_id;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customer_name;

    @Column(name = "customer_contact_person", nullable = false, length = 150)
    private String customer_contact_person;

    @Column(name = "customer_email", nullable = false)
    private String customer_email;

    @Column(name = "customer_phone", length = 10)
    private String customer_phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Address> addresses;
}