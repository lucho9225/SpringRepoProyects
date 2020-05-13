package com.cursospring.app.ws.users.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.cursospring.app.ws.users.request.UserRequestCreate;
import com.cursospring.app.ws.users.request.UserRequestUpdate;
import com.cursospring.app.ws.users.response.UserResponse;

public interface UserService {
	
	public void createUser(UserRequestCreate userDetails);
	
	public UserResponse updateUser(UserRequestUpdate userDetails, long userId);
	
	public HttpStatus deleteUser(long userId);
	
	public UserResponse getUser(long userId);
	
	public List<UserResponse> getUsers(String tipoDoc, String numdoc);
	
	public List<UserResponse> getUsersByAge(int edad);
	
	public List<UserResponse> getAllUsers(int page, int limit);

}
