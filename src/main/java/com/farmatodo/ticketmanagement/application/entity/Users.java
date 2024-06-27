package com.farmatodo.ticketmanagement.application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "fk_document_type_id", nullable = false)
	private Long documentTypeId;
	
	@Column(name = "identification", nullable = false)
	private String identification;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "status", nullable = false)
	private boolean status;
	
}
