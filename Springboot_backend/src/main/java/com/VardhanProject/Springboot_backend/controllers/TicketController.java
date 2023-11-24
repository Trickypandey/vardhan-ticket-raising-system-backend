package com.VardhanProject.Springboot_backend.controllers;

import com.VardhanProject.Springboot_backend.Utilities.TicketStatus;
import com.VardhanProject.Springboot_backend.payloads.TicketDto;
import com.VardhanProject.Springboot_backend.payloads.UserDto;
import com.VardhanProject.Springboot_backend.repos.UserRepo;
import com.VardhanProject.Springboot_backend.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000,http://example.com")
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

    @PatchMapping("/{ticketId}/assign")
    public ResponseEntity<TicketDto> updateTicketAssignedTo(
            @PathVariable Integer ticketId,
            @RequestParam Integer newAssignedTo) {
        TicketDto updatedTicket = ticketService.updateTicketAssignedTo(ticketId, newAssignedTo);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
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


    @GetMapping("/new")
    public ResponseEntity<List<TicketDto>> getNewTickets() {
        List<TicketDto> newTickets = ticketService.getTicketsByStatus(String.valueOf(TicketStatus.NEW));
        return new ResponseEntity<>(newTickets, HttpStatus.OK);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<TicketDto>> getPendingTickets() {
        List<TicketDto> pendingTickets = ticketService.getTicketsByStatus(String.valueOf(TicketStatus.ASSIGNED));
        return new ResponseEntity<>(pendingTickets, HttpStatus.OK);
    }

    @GetMapping("/completed")
    public ResponseEntity<List<TicketDto>> getCompletedTickets() {
        List<TicketDto> completedTickets = ticketService.getTicketsByStatus(String.valueOf(TicketStatus.RESOLVED));
        return new ResponseEntity<>(completedTickets, HttpStatus.OK);
    }
    @GetMapping("/userWithTicket")
    public ResponseEntity<UserDto> getUserWithTicketId( @RequestParam Integer ticketId) {
        UserDto user = this.ticketService.getUsersByTicketId(ticketId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
