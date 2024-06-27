package com.farmatodo.ticketmanagement.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farmatodo.ticketmanagement.application.constants.ApplicationConstants;
import com.farmatodo.ticketmanagement.application.entity.Tickets;
import com.farmatodo.ticketmanagement.application.service.TicketsService;
import com.farmatodo.ticketmanagement.application.utlis.ApiResponseUtils;

@RestController
@RequestMapping("api/v1/tickets")
public class TicketsController {
	
	@Autowired
	private TicketsService ticketsService;
	
	@GetMapping("/getTickets")
	public ResponseEntity<ApiResponseUtils<Page<Tickets>>> getAllTickets(@RequestParam("page") int page,
			@RequestParam("size") int size){
		try {
			Page<Tickets> tickets = ticketsService.getAllTickets(page, size);
			ApiResponseUtils<Page<Tickets>> response = new ApiResponseUtils<>(ApplicationConstants.GET_ALL_TICKETS_SUCCESS_DESCRIPTION, tickets, 200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping("/getTicketById/{id}")
	public ResponseEntity<ApiResponseUtils<Tickets>> getTicketById(@PathVariable("id") Long id){
		try {
			Tickets ticket = ticketsService.getTicketById(id);
			ApiResponseUtils<Tickets> response = new ApiResponseUtils<>(ApplicationConstants.GET_TICKET_BY_ID_SUCCESS_DESCRIPTION, ticket, 200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping("/getTicketByCode/{code}")
	public ResponseEntity<ApiResponseUtils<Tickets>> getTicketByCode(@PathVariable("code") String code){
		try {
			Tickets ticket = ticketsService.getTicketByCode(code);
			ApiResponseUtils<Tickets> response = new ApiResponseUtils<>(ApplicationConstants.GET_TICKET_BY_CODE_SUCCESS_DESCRIPTION, ticket, 200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	
	@PostMapping("/createTicket/")
	public ResponseEntity<ApiResponseUtils<Tickets>> createTicket(@RequestBody Tickets ticket){
		try {
			Tickets savedTicket = ticketsService.saveTickets(ticket);
			ApiResponseUtils<Tickets> response = new ApiResponseUtils<>(ApplicationConstants.CREATE_TICKET_SUCCESS_DESCRIPTION, savedTicket, 200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PutMapping("/editTicket/")
	public ResponseEntity<ApiResponseUtils<Tickets>> editTicket(@RequestBody Tickets ticket){
		try {
			Tickets editedTicket = ticketsService.editTickets(ticket);
			ApiResponseUtils<Tickets> response = new ApiResponseUtils<>(ApplicationConstants.UPDATE_TICKET_SUCCESS_DESCRIPTION, editedTicket, 200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@DeleteMapping("/closeTicket/{code}")
	public ResponseEntity<ApiResponseUtils<Tickets>> disableTicket(@PathVariable("code") String code){
		try {
			Tickets closeTicket = ticketsService.closeTicketsByCode(code);
			ApiResponseUtils<Tickets> response = new ApiResponseUtils<>(ApplicationConstants.CLOSED_TICKET_SUCCESS_DESCRIPTION, closeTicket, 200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}

}
