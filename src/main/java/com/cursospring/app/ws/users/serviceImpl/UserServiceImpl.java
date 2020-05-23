package com.cursospring.app.ws.users.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cursospring.app.ws.users.entity.Users;
import com.cursospring.app.ws.users.repositories.UsersSqlRepository;
import com.cursospring.app.ws.users.request.UserRequestCreate;
import com.cursospring.app.ws.users.request.UserRequestUpdate;
import com.cursospring.app.ws.users.response.UserResponse;
import com.cursospring.app.ws.users.service.UserService;
import com.cursospring.app.ws.users.service.UserServiceMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserServiceMapper mapper;
	
	@Autowired
	private UsersSqlRepository userSqlRepository;

	private Users userIn;
	
	@Override
	public void createUser(UserRequestCreate userDetails) {
		// TODO Auto-generated method stub
		userIn = mapper.mappUserInCreate(userDetails);
		
		try {
			/*   Rutina create en mySQL     */
			userSqlRepository.save(userIn);
			System.out.println("Registro Insertado Correctamente");
			
		}finally {
			
		}
	}

	@Override
	public UserResponse updateUser(UserRequestUpdate userDetails, long userId) {
		// TODO Auto-generated method stub
		UserResponse userResponse;
		userIn = mapper.mappUserInUpdate(userDetails, userId);
		
		try {
			Users userOut = userSqlRepository.save(userIn);	
			System.out.println("Registro actualizado correctamente en BBDD");
			userResponse = mapper.mappUserOut(userOut);	
			
		}finally {
			
		}
		return userResponse;
	}

	@Override
	public HttpStatus deleteUser(long userId) {
		// TODO Auto-generated method stub
		try {
			userSqlRepository.deleteById(userId);
			System.out.println("Registro borrado correctamente de BBDD");
			return HttpStatus.NO_CONTENT;
			
		}catch (IllegalArgumentException e) {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public UserResponse getUser(long userId) {
		// TODO Auto-generated method stub
		UserResponse userResponse = new UserResponse();
		try {
			if(userSqlRepository.findById(userId).isPresent()) userResponse = mapper.mappUserOut(userSqlRepository.findById(userId).get());
			else return null;//Lanzar una excepción posiblemente con httpStatus o personalizada
		}finally {
			
		}		
		return userResponse;
	}
	
	@Override
	public List<UserResponse> getUsers(String tipoDoc,String numdoc) {
		// TODO Auto-generated method stub
		List<UserResponse> userResponseOutList = new ArrayList<UserResponse>();
		List<Users> userResponseList;
		
		try {
			userResponseList = userSqlRepository.findByDoc(tipoDoc,numdoc);
			
			for (Users userResponseTmp:userResponseList) {
				UserResponse userResponse = new UserResponse();
				userResponse = mapper.mappUserOut(userResponseTmp);
		
				userResponseOutList.add(userResponse);
			}
		}finally {
			
		}
		
		return userResponseOutList;
	}

	@Override
	public List<UserResponse> getUsersByAge(int edad){
		
		List<UserResponse> userResponseOutList = new ArrayList<UserResponse>();
		List<Users> userResponseList;
		
		try {
			userResponseList = userSqlRepository.findByAge(edad);
			
			for (Users userResponseTmp:userResponseList) {
				UserResponse userResponse = new UserResponse();
				userResponse = mapper.mappUserOut(userResponseTmp);
		
				userResponseOutList.add(userResponse);
			}
		}finally {
		}
		return userResponseOutList;
	}
	
	@Override
	public List<UserResponse> getAllUsers(int page,int limit){
		
		List<UserResponse> userResponseOutList = new ArrayList<UserResponse>();
		List<Users> userResponseList;
		
		try {
			userResponseList = userSqlRepository.findWithLimit(limit);
			
			for (Users userResponseTmp:userResponseList) {
				UserResponse userResponse = new UserResponse();
				userResponse = mapper.mappUserOut(userResponseTmp);
		
				userResponseOutList.add(userResponse);
			}			
		}finally {

		}
		
		return userResponseOutList;
	}
}
