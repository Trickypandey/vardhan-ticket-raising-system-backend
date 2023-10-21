package com.VardhanProject.Springboot_backend.services.impl;

import com.VardhanProject.Springboot_backend.entities.Tickets;
import com.VardhanProject.Springboot_backend.exceptions.ResourceNotFoundException;
import com.VardhanProject.Springboot_backend.payloads.TicketDto;
import com.VardhanProject.Springboot_backend.repos.TicketRepository;
import com.VardhanProject.Springboot_backend.services.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        Tickets newTicket = modelMapper.map(ticketDto, Tickets.class);
        Tickets savedTicket = ticketRepository.save(newTicket);
        return modelMapper.map(savedTicket, TicketDto.class);
    }

    @Override
    public List<TicketDto> getAllTickets() {
        List<Tickets> tickets = ticketRepository.findAll();
        return tickets.stream()
                .map(ticket -> modelMapper.map(ticket, TicketDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TicketDto getTicketById(Integer ticketId) {
        Optional<Tickets> optionalTicket = ticketRepository.findById(ticketId);
        return optionalTicket.map(ticket -> modelMapper.map(ticket, TicketDto.class)).orElse(null);
    }

    @Override
    public TicketDto updateTicket(Integer ticketId, TicketDto ticketDto) {
        Optional<Tickets> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            Tickets existingTicket = optionalTicket.get();
            modelMapper.map(ticketDto, existingTicket); // Update properties using modelMapper
            Tickets updatedTicket = ticketRepository.save(existingTicket);
            return modelMapper.map(updatedTicket, TicketDto.class);
        } else {
            return null; // Handle the case where the ticket is not found
        }
    }

    @Override
    public void deleteTicket(Integer ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    @Override
    public TicketDto updateTicketStatus(Integer ticketId, String newStatus) {
        Optional<Tickets> optionalTicket = ticketRepository.findById(ticketId);

        if (optionalTicket.isPresent()) {
            Tickets existingTicket = optionalTicket.get();

            existingTicket.setStatus(newStatus);

            // Save the updated ticket
            Tickets updatedTicket = ticketRepository.save(existingTicket);

            return modelMapper.map(updatedTicket, TicketDto.class);
        } else {
            throw new ResourceNotFoundException("Ticket with ID " , "ticketId" , ticketId);
        }
    }

    @Override
    public TicketDto updateTicketAssignedTo(Integer ticketId, Integer newAssignedTo) {
        Optional<Tickets> optionalTicket = ticketRepository.findById(ticketId);

        if (optionalTicket.isPresent()) {
            Tickets existingTicket = optionalTicket.get();

            existingTicket.setAssignedTo(newAssignedTo);

            // Save the updated ticket
            Tickets updatedTicket = ticketRepository.save(existingTicket);

            return modelMapper.map(updatedTicket, TicketDto.class);
        } else {
            throw new ResourceNotFoundException("Ticket with ID " , "ticketId" , ticketId);
        }
    }
    @Override
    public List<TicketDto> getTicketsByStatus(String status) {
        List<Tickets> tickets = ticketRepository.findByStatus(status);

        // Convert Ticket entities to TicketDto objects
        return tickets.stream()
                .map(ticket -> modelMapper.map(ticket, TicketDto.class))
                .collect(Collectors.toList());
    }
}
