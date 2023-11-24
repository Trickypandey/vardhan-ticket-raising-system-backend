package com.VardhanProject.Springboot_backend.services;

import com.VardhanProject.Springboot_backend.payloads.TicketDto;
import com.VardhanProject.Springboot_backend.payloads.UserDto;

import java.util.List;

public interface TicketService {
    List<UserDto> getUsersWithNoTasksOrCancelledOrCompletedTasks();
    UserDto getUsersByTicketId(Integer ticketId);
    TicketDto createTicket(TicketDto ticketDto);
    List<TicketDto> getAllTickets();
    TicketDto getTicketById(Integer ticketId);
    TicketDto updateTicket(Integer ticketId, TicketDto ticketDto);
    void deleteTicket(Integer ticketId);
    TicketDto updateTicketStatus(Integer ticketId, String newStatus);
    TicketDto updateTicketAssignedTo(Integer ticketId, Integer newAssignedTo);

    List<TicketDto> getTicketsByStatus(String status);
}