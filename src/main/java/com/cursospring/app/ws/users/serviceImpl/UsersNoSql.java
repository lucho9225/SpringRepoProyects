package com.cursospring.app.ws.users.serviceImpl;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cursospring.app.ws.users.service.IUsersNoSql;

@Document(collection = "clients")
public class UsersNoSql implements IUsersNoSql {

	private String image;
	
	@Id
	@Indexed(unique = true)
	private long id;
	
	
	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	@Override
	public void setImage(String image) {
		// TODO Auto-generated method stub
		this.image = image;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

}
