package com.cursospring.app.ws.users.service;

import com.cursospring.app.ws.Users;
import com.cursospring.app.ws.users.request.UserRequestCreate;
import com.cursospring.app.ws.users.request.UserRequestUpdate;
import com.cursospring.app.ws.users.response.UserResponse;

public interface UserServiceMapper {
	

	Users mappUserInCreate(UserRequestCreate userDetails);
	
	Users mappUserInUpdate(UserRequestUpdate userDetails,long userId);
	
	UserResponse mappUserOut(Users users);

}
