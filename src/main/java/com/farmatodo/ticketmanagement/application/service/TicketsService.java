package com.farmatodo.ticketmanagement.application.service;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.farmatodo.ticketmanagement.application.entity.Tickets;

@Service
public interface TicketsService {
	public Page<Tickets> getAllTickets(int page, int size);
	public Tickets getTicketById(Long id);
	public Tickets getTicketByCode(String code);
	public Tickets saveTickets(Tickets ticket);
	public Tickets editTickets(Tickets ticket);
	public Tickets closeTicketsByCode(String code);

}
