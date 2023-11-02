package com.VardhanProject.Springboot_backend.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TicketDto {
    private Integer ticketId;
    private String query;
    private String status;
    private Integer customerId;
//    private Integer assignedTo;
    private String creationDate;
    private String remarks;

}
