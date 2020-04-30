package com.cursospring.app.ws.users.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursospring.app.ws.users.request.UserRequestCreate;
import com.cursospring.app.ws.users.request.UserRequestUpdate;
import com.cursospring.app.ws.users.response.UserResponse;
import com.cursospring.app.ws.users.service.UserService;

@RestController
@RequestMapping(path="/users")
public class UsersRestController {
	
	@Autowired
	UserService user;
	
	@GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<UserResponse> getUsers(
			@RequestParam(value="page",defaultValue="1") int page,
			@RequestParam(value="limit",defaultValue="50") int limit,
			@RequestParam(required=false,value="tipoDoc") String tipoDoc,
			@RequestParam(required=false ,value="numdoc") String numdoc,
			@RequestParam(required = false,value="edad",defaultValue="0") int edad) {
		List<UserResponse> listUserResponse = new ArrayList<UserResponse>();
		
		if(numdoc!=null ) {
			if(tipoDoc != null)listUserResponse = user.getUsers(tipoDoc,numdoc);
		}else if(edad!=0){
			listUserResponse = user.getUsersByAge(edad);
		}else {
			listUserResponse = user.getAllUsers(page,limit);
		}
		return listUserResponse;
	}
	
	@GetMapping(path="/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public UserResponse getUser(@PathVariable long userId) {
		
		UserResponse userResponse = user.getUser(userId);
		
		return userResponse;
	}
	
	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE})
	public UserResponse postUser(@Valid @RequestBody UserRequestCreate userDetails) {
		
		UserResponse userResponse = user.createUser(userDetails);
		
		return userResponse;
	}
	
	@PutMapping(path="/{userId}",consumes= {MediaType.APPLICATION_JSON_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE})
	public UserResponse updateUser(@PathVariable long userId, @Valid @RequestBody UserRequestUpdate userDetails) {
		
		UserResponse userResponse = user.updateUser(userDetails,userId);
		
		return userResponse;
	}
	
	@DeleteMapping(path="/{userId}")
	public HttpStatus deleteUser(@PathVariable long userId) {
		
		HttpStatus statusResponse = user.deleteUser(userId);
		
		return statusResponse;
	}
	
	

}
