package com.farmatodo.ticketmanagement.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmatodo.ticketmanagement.application.constants.ApplicationConstants;
import com.farmatodo.ticketmanagement.application.entity.Users;
import com.farmatodo.ticketmanagement.application.service.UsersService;
import com.farmatodo.ticketmanagement.application.utlis.ApiResponseUtils;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/getUsers")
	public ResponseEntity<ApiResponseUtils<List<Users>>> getAllUsers(){
		try {
			List<Users> users = usersService.getAllUsers();
			ApiResponseUtils<List<Users>> response = new ApiResponseUtils<>(ApplicationConstants.GET_ALL_USERS_SUCCESS_DESCRIPTION, users, 200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<ApiResponseUtils<Users>> getUserById(@PathVariable("id") Integer id){
		try {
			Users user = usersService.getUserById(id);
			ApiResponseUtils<Users> response = new ApiResponseUtils<>(ApplicationConstants.GET_USER_BY_ID_SUCCESS_DESCRIPTION, user, 200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping("/getUserByIdentification/{identification}")
	public ResponseEntity<ApiResponseUtils<Users>> getUserByIdentification(@PathVariable("identification") String identification){
		try {
			Users user = usersService.getUserByIdentification(identification);
			ApiResponseUtils<Users> response = new ApiResponseUtils<>(ApplicationConstants.GET_USER_BY_IDENTIFICATION_SUCCESS_DESCRIPTION, user, 200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<ApiResponseUtils<Users>> getUserByEmail(@PathVariable("email") String email){
		try {
			Users user = usersService.getUserByEmail(email);
			ApiResponseUtils<Users> response = new ApiResponseUtils<>(ApplicationConstants.GET_USER_BY_IDENTIFICATION_SUCCESS_DESCRIPTION, user, 200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PostMapping("/createUser/")
	public ResponseEntity<ApiResponseUtils<Users>> createUser(@RequestBody Users user){
		try {
			Users savedUser = usersService.saveUser(user);
			ApiResponseUtils<Users> response = new ApiResponseUtils<>(ApplicationConstants.CREATE_USER_SUCCESS_DESCRIPTION, savedUser, 200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PutMapping("/editUser/")
	public ResponseEntity<ApiResponseUtils<Users>> editUser(@RequestBody Users user){
		try {
			Users editedUser = usersService.editUser(user);
			ApiResponseUtils<Users> response = new ApiResponseUtils<>(ApplicationConstants.UPDATE_USER_SUCCESS_DESCRIPTION, editedUser, 200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@DeleteMapping("/disableUser/{identification}")
	public ResponseEntity<ApiResponseUtils<Users>> disableUser(@PathVariable("identification") String identification){
		try {
			Users disableUser = usersService.disableUserByIdentification(identification);
			ApiResponseUtils<Users> response = new ApiResponseUtils<>(ApplicationConstants.DISABLE_USER_SUCCESS_DESCRIPTION, disableUser, 200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}

}
