package com.VardhanProject.Springboot_backend.repos;


import com.VardhanProject.Springboot_backend.entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Tickets, Integer> {
}
