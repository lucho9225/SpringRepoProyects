package com.cursospring.app.ws.users.service;

import com.cursospring.app.ws.users.entity.Users;
import com.cursospring.app.ws.users.entity.UsersNoSql;
import com.cursospring.app.ws.users.request.UserRequestCreate;
import com.cursospring.app.ws.users.request.UserRequestUpdate;
import com.cursospring.app.ws.users.response.UserResponse;

public interface UserServiceMapper {
	

	public Users mappUserInCreate(UserRequestCreate userDetails);
	
	public Users mappUserInUpdate(UserRequestUpdate userDetails,long userId);
	
	public UserResponse mappUserOut(Users users);
	
	public UsersNoSql mappUserNoSqlInUpdate(UserRequestUpdate userDetails,String userId);
	
	public UsersNoSql mappUserNoSqlInCreate(UserRequestCreate userDetails,String userId);

}
