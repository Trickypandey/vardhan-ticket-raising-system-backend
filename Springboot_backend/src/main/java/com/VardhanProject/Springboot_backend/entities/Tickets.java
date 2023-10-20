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
@Table(name = "ticketTable")
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @Column(name = "query")
    private String query;

    @Column(name = "status")
    private String status;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "assigned_to")
    private Integer assignedTo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private String creationDate;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "last_attended_date")
    private String lastAttendDate;

    @Column(name = "address_id")
    private Integer addressId;
}
