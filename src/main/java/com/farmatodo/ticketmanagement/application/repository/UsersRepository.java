package com.farmatodo.ticketmanagement.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.farmatodo.ticketmanagement.application.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	public Users findByIdentification(String identification);
	public Users findByEmail(String email);
	
	@Query(value = "SELECT MAX(id) FROM USERS", nativeQuery = true)
	public Integer findLastUserId();
}
