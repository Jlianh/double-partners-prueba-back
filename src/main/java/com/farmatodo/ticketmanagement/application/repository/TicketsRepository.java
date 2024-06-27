package com.farmatodo.ticketmanagement.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.farmatodo.ticketmanagement.application.entity.Tickets;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Long>, PagingAndSortingRepository<Tickets, Long> {
	public Tickets findByTicketCode(String code);
	
	@Query(value = "SELECT MAX(id) FROM TICKETS", nativeQuery = true)
	public Long findLastTicketId();
}
