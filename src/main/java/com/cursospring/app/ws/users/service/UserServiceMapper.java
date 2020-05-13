package com.cursospring.app.ws.users.service;

import com.cursospring.app.ws.users.request.UserRequestCreate;
import com.cursospring.app.ws.users.request.UserRequestUpdate;
import com.cursospring.app.ws.users.response.UserResponse;
import com.cursospring.app.ws.users.serviceImpl.Users;
import com.cursospring.app.ws.users.serviceImpl.UsersNoSql;

public interface UserServiceMapper {
	

	public Users mappUserInCreate(UserRequestCreate userDetails);
	
	public Users mappUserInUpdate(UserRequestUpdate userDetails,long userId);
	
	public UserResponse mappUserOut(Users users);
	
	public UsersNoSql mappUserNoSqlInUpdate(UserRequestUpdate userDetails,long userId);

}
