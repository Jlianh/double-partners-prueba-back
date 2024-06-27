package com.farmatodo.ticketmanagement.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.farmatodo.ticketmanagement.application.entity.Users;

@Service
public interface UsersService {
	public List<Users> getAllUsers();
	public Users getUserById(Integer id);
	public Users getUserByIdentification(String identification);
	public Users getUserByEmail(String email);
	public Users saveUser(Users user);
	public Users editUser(Users user);
	public Users disableUserByIdentification(String identification);
}
