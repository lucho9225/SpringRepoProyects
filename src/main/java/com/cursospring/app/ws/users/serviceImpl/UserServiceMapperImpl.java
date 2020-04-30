package com.cursospring.app.ws.users.serviceImpl;

import org.springframework.stereotype.Service;

import com.cursospring.app.ws.Users;
import com.cursospring.app.ws.users.request.UserRequestCreate;
import com.cursospring.app.ws.users.request.UserRequestUpdate;
import com.cursospring.app.ws.users.response.UserResponse;
import com.cursospring.app.ws.users.service.UserServiceMapper;

@Service
public class UserServiceMapperImpl implements UserServiceMapper {
	
	
	@Override
	public Users mappUserInCreate(UserRequestCreate userDetails) {
		// TODO Auto-generated method stub
		Users user = new Users();
		
		user.setNombre(userDetails.getFirstName()); 
		user.setApellido(userDetails.getLastName());
		user.setTipoDoc(userDetails.getDocumentType());
		user.setNumdoc(userDetails.getDocumentNumber());
		user.setEdad(userDetails.getEdad());
		user.setCiudadNacimiento(userDetails.getCiudadNacimiento());
		
		return user;
	}

	@Override
	public Users mappUserInUpdate(UserRequestUpdate userDetails, long userId) {
		// TODO Auto-generated method stub
		Users user = new Users();
		
		user.setId(userId);
		user.setNombre(userDetails.getFirstName()); 
		user.setApellido(userDetails.getLastName());
		user.setTipoDoc(userDetails.getDocumentType());
		user.setNumdoc(userDetails.getDocumentNumber());
		user.setEdad(userDetails.getEdad());
		user.setCiudadNacimiento(userDetails.getCiudadNacimiento());
		
		return user;
	}

	@Override
	public UserResponse mappUserOut(Users userDetails) {
		// TODO Auto-generated method stub
		UserResponse user = new UserResponse();
		
		user.setId(userDetails.getId());
		user.setFirstName(userDetails.getNombre()); 
		user.setLastName(userDetails.getApellido());
		user.setDocumentType(userDetails.getTipoDoc());
		user.setDocumentNumber(userDetails.getNumdoc());
		user.setEdad(userDetails.getEdad());
		user.setCiudadNacimiento(userDetails.getCiudadNacimiento());
		
		return user;
	}

}
