package com.VardhanProject.Springboot_backend.controllers;

import com.VardhanProject.Springboot_backend.payloads.TicketDto;
import com.VardhanProject.Springboot_backend.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    /// remerber to add the update status endpoint to postmen
    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
        TicketDto createdTicket = ticketService.createTicket(ticketDto);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public List<TicketDto> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable Integer ticketId) {
        TicketDto ticket = ticketService.getTicketById(ticketId);
        if (ticket != null) {
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<TicketDto> updateTicket(
            @PathVariable Integer ticketId,
            @RequestBody TicketDto ticketDto) {
        TicketDto updatedTicket = ticketService.updateTicket(ticketId, ticketDto);
        if (updatedTicket != null) {
            return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Integer ticketId) {
        ticketService.deleteTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{ticketId}/status")
    public ResponseEntity<TicketDto> updateTicketStatus(
            @PathVariable Integer ticketId,
            @RequestParam String newStatus) {

        TicketDto updatedTicket = ticketService.updateTicketStatus(ticketId, newStatus);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }

    @PatchMapping("/{ticketId}/assign")
    public ResponseEntity<TicketDto> updateTicketAssignedTo(
            @PathVariable Integer ticketId,
            @RequestParam Integer newAssignedTo) {
        TicketDto updatedTicket = ticketService.updateTicketAssignedTo(ticketId, newAssignedTo);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }
}
