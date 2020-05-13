package com.cursospring.app.ws.users.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UsersNoSql {

	private String image;
	
	@Id
	@Indexed(unique = true)
	private String numdoc;
	

	public String getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	public void setImage(String image) {
		// TODO Auto-generated method stub
		this.image = image;
	}

	public String getNumdoc() {
		// TODO Auto-generated method stub
		return numdoc;
	}

	public void setNumdoc(String numdoc) {
		// TODO Auto-generated method stub
		this.numdoc = numdoc;
	}

}
