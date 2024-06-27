package com.farmatodo.ticketmanagement.application.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.farmatodo.ticketmanagement.application.entity.Tickets;
import com.farmatodo.ticketmanagement.application.repository.TicketsRepository;
import com.farmatodo.ticketmanagement.application.service.TicketsService;
import com.farmatodo.ticketmanagement.application.utlis.CodeGeneratorUtils;

@Service
public class TicketsServiceImpl implements TicketsService {

	@Autowired
	private TicketsRepository ticketsRepository;

	public Page<Tickets> getAllTickets(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ticketsRepository.findAll(pageable);
	}

	public Tickets getTicketById(Long id) {
		Tickets ticket = ticketsRepository.findById(id).get();
		return ticket;
	}

	public Tickets getTicketByCode(String code) {
		Tickets ticket = ticketsRepository.findByTicketCode(code);
		return ticket;
	}

	public Tickets saveTickets(Tickets ticket) {
		Long lastTicketId = ticketsRepository.findLastTicketId();
		Long ticketId = (lastTicketId != null) ? lastTicketId + 1 : 1;
		ticket.setId(ticketId);
		ticket.setTicketCode(CodeGeneratorUtils.generateRandomString());
		ticket.setCreationDate(LocalDateTime.now());
		ticket.setUpdateDate(LocalDateTime.now());
		Tickets savedTicket = ticketsRepository.save(ticket);
		return savedTicket;
	}

	public Tickets editTickets(Tickets ticket) {
		Tickets editedTicket = ticket;
		editedTicket.setId(ticket.getId());
		editedTicket.setUpdateDate(LocalDateTime.now());
		editedTicket = ticketsRepository.save(editedTicket);
		return editedTicket;
	}

	public Tickets closeTicketsByCode(String code) {
		Tickets ticket = ticketsRepository.findByTicketCode(code);
		ticket.setState(2);
		ticket = ticketsRepository.save(ticket);
		return ticket;
	}

	
}
