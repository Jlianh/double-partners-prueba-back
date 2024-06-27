package com.farmatodo.ticketmanagement.application.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TICKETS")
@Data
@NoArgsConstructor
public class Tickets {
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "ticket_code")
	private String ticketCode;
	
	@Column(name = "fk_user_id", nullable = false)
	private Long user;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "creation_date", nullable = false)
	private LocalDateTime creationDate;
	
	@Column(name = "update_date", nullable = false)
	private LocalDateTime updateDate;
	
	@Column(name = "fk_state_id", nullable = false)
	private Integer state;
	
	
}
