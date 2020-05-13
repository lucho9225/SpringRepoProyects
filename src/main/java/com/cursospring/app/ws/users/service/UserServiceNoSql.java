package com.cursospring.app.ws.users.service;

import java.util.List;

import com.cursospring.app.ws.users.entity.UsersNoSql;
import com.cursospring.app.ws.users.request.UserRequestCreate;;

public interface UserServiceNoSql {

	public void saveUsersNoSQL(UserRequestCreate user, String documentNumber);
	
	public void deleteUser(UsersNoSql user);
	
	public UsersNoSql findById(String id);
	
	public List<UsersNoSql> findAll();
	
	public UsersNoSql updateClientNoSQL(UsersNoSql user);
}
