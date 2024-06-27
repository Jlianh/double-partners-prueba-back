package com.farmatodo.ticketmanagement.application.dto;

import lombok.Data;

@Data
public class UsersDTO {
	
	private Long documentTypeId;
	private String identification;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String email;
	private boolean status;
}
