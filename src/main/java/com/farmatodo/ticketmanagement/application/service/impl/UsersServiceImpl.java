package com.farmatodo.ticketmanagement.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmatodo.ticketmanagement.application.entity.Users;
import com.farmatodo.ticketmanagement.application.repository.UsersRepository;
import com.farmatodo.ticketmanagement.application.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}
	
	public Users getUserById(Integer id) {
		Users user = usersRepository.findById(id).get();
		return user;
	}
	public Users getUserByIdentification(String identification) {
		Users user = usersRepository.findByIdentification(identification);
		return user;
	}
	public Users getUserByEmail(String email) {
		Users user = usersRepository.findByEmail(email);
		return user;
	}
	public Users saveUser(Users user) {
		Integer lastUserId = usersRepository.findLastUserId();
		Integer userId = (lastUserId != null) ? lastUserId + 1 : 1;
		user.setId(userId);
		Users savedUser = usersRepository.save(user);
		return savedUser;
	}
	public Users editUser(Users user) {
		Users editedUser = user;
		editedUser.setId(user.getId());
		editedUser = usersRepository.save(editedUser);
		return editedUser;
	}
	public Users disableUserByIdentification(String identification) {
		Users user = usersRepository.findByIdentification(identification);
		user.setStatus(false);
		user = usersRepository.save(user);
		return user;
	}
	
	
}
