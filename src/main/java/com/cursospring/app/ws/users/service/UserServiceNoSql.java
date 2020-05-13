package com.cursospring.app.ws.users.service;

import java.util.List;

import com.cursospring.app.ws.users.serviceImpl.UsersNoSql;;

public interface UserServiceNoSql {

	public void saveUsersNoSQL(UsersNoSql user);
	
	public void deleteUser(UsersNoSql user);
	
	public UsersNoSql findById(Long id);
	
	public List<UsersNoSql> findAll();
	
	public UsersNoSql updateClientNoSQL(UsersNoSql user);
}
