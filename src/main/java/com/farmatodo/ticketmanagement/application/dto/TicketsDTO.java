package com.farmatodo.ticketmanagement.application.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class TicketsDTO {
	
	private String ticketCode;
	private Long userId;
	private Date creationDate;
	private Date updateDate;
	private Long stateId;
}
