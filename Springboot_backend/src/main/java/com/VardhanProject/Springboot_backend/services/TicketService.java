package com.VardhanProject.Springboot_backend.services;

import com.VardhanProject.Springboot_backend.payloads.TicketDto;

import java.util.List;

public interface TicketService {
    TicketDto createTicket(TicketDto ticketDto);
    List<TicketDto> getAllTickets();
    TicketDto getTicketById(Integer ticketId);
    TicketDto updateTicket(Integer ticketId, TicketDto ticketDto);
    void deleteTicket(Integer ticketId);
    TicketDto updateTicketStatus(Integer ticketId, String newStatus);
    TicketDto updateTicketAssignedTo(Integer ticketId, Integer newAssignedTo);
}