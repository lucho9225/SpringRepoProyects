package com.cursospring.app.ws.users.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cursospring.app.ws.Users;
import com.cursospring.app.ws.users.request.UserRequestCreate;
import com.cursospring.app.ws.users.request.UserRequestUpdate;
import com.cursospring.app.ws.users.response.UserResponse;
import com.cursospring.app.ws.users.service.UserService;
import com.cursospring.app.ws.users.service.UserServiceMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserServiceMapper mapper;
	
	String dbConexionSource = "hibernate.cfg.xml";
	
	@Override
	public UserResponse createUser(UserRequestCreate userDetails) {
		// TODO Auto-generated method stub
		
		UserResponse userResponse;
		Users userIn = mapper.mappUserInCreate(userDetails);
		
		SessionFactory miFactory = new Configuration().configure(dbConexionSource).addAnnotatedClass(Users.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			miSession.save(userIn); 
			miSession.getTransaction().commit();
			System.out.println("Registro Insertado Correctamente");
			miSession.beginTransaction();
			Users userOut = miSession.get(Users.class, userIn.getId());
			miSession.getTransaction().commit();
			userResponse = mapper.mappUserOut(userOut);
			miSession.close();
			
		}finally {
			miFactory.close();
		}
		return userResponse;
	}

	@Override
	public UserResponse updateUser(UserRequestUpdate userDetails, long userId) {
		// TODO Auto-generated method stub
		UserResponse userResponse;
		Users userIn = mapper.mappUserInUpdate(userDetails, userId);
		
		SessionFactory miFactory = new Configuration().configure(dbConexionSource).addAnnotatedClass(Users.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			
			miSession.beginTransaction();
			miSession.createQuery("update Users "
					+ "set nombre = '" + userIn.getNombre()+"',"
					+ "apellido = '" + userIn.getApellido()+"',"
					+ "tipoDoc = '" + userIn.getTipoDoc()+"',"
					+ "numdoc = '" + userIn.getNumdoc()+"',"
					+ "edad = " + userIn.getEdad()+","
					+ "ciudadNacimiento = '" + userIn.getCiudadNacimiento()+"'"
					+ " where id = "+ userIn.getId())
					.executeUpdate();
			
			miSession.getTransaction().commit();
			System.out.println("Registro actualizado correctamente en BBDD");
			miSession.beginTransaction();
			Users userOut = miSession.get(Users.class, userIn.getId());
			miSession.getTransaction().commit();
			userResponse = mapper.mappUserOut(userOut);	
			miSession.close();
			
		}finally {
			miFactory.close();
		}
		return userResponse;
	}

	@Override
	public HttpStatus deleteUser(long userId) {
		// TODO Auto-generated method stub
		
		Boolean exitoso=Boolean.FALSE;
		SessionFactory miFactory = new Configuration().configure(dbConexionSource).addAnnotatedClass(Users.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			miSession.createQuery("delete Users where id = "+userId).executeUpdate();
			miSession.getTransaction().commit();
			System.out.println("Registro borrado correctamente de BBDD");
			exitoso = Boolean.TRUE;
			miSession.close();
			
		}finally {
			miFactory.close();
		}
		if(exitoso)return HttpStatus.NO_CONTENT;
		else return HttpStatus.BAD_REQUEST;
	}

	@Override
	public UserResponse getUser(long userId) {
		// TODO Auto-generated method stub
		UserResponse userResponse = new UserResponse();
		List<Users> userResponseList;
		
		SessionFactory miFactory = new Configuration().configure(dbConexionSource).addAnnotatedClass(Users.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		try {
			miSession.beginTransaction();
			userResponseList = miSession.createQuery("from Users us where us.id = "+userId).getResultList();
			
			for (Users userResponseTmp:userResponseList) {
				userResponse.setId(userResponseTmp.getId());
				userResponse.setFirstName(userResponseTmp.getNombre());
				userResponse.setLastName(userResponseTmp.getApellido());
				userResponse.setDocumentType(userResponseTmp.getTipoDoc());
				userResponse.setDocumentNumber(userResponseTmp.getNumdoc());
				userResponse.setEdad(userResponseTmp.getEdad());
				userResponse.setCiudadNacimiento(userResponseTmp.getCiudadNacimiento());
			}
			miSession.getTransaction().commit();
			miSession.close();
			
		}finally {
			miFactory.close();
		}		
		return userResponse;
	}
	
	@Override
	public List<UserResponse> getUsers(String tipoDoc,String numdoc) {
		// TODO Auto-generated method stub
		List<UserResponse> userResponseOutList = new ArrayList<UserResponse>();
		List<Users> userResponseList;
		
		SessionFactory miFactory = new Configuration().configure(dbConexionSource).addAnnotatedClass(Users.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			userResponseList = miSession.createQuery("from Users us where us.tipoDoc = '"+tipoDoc+"' and numdoc= '"+numdoc+"'").getResultList();
			
			for (Users userResponseTmp:userResponseList) {
				UserResponse userResponse = new UserResponse();
				userResponse.setId(userResponseTmp.getId());
				userResponse.setFirstName(userResponseTmp.getNombre());
				userResponse.setLastName(userResponseTmp.getApellido());
				userResponse.setDocumentType(userResponseTmp.getTipoDoc());
				userResponse.setDocumentNumber(userResponseTmp.getNumdoc());
				userResponse.setEdad(userResponseTmp.getEdad());
				userResponse.setCiudadNacimiento(userResponseTmp.getCiudadNacimiento());
				
				userResponseOutList.add(userResponse);
				
			}
			miSession.getTransaction().commit();
			miSession.close();
			
		}finally {
			miFactory.close();
		}
		
		return userResponseOutList;
	}

	@Override
	public List<UserResponse> getUsersByAge(int edad){
		
		List<UserResponse> userResponseOutList = new ArrayList<UserResponse>();
		List<Users> userResponseList;
		SessionFactory miFactory = new Configuration().configure(dbConexionSource).addAnnotatedClass(Users.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			userResponseList = miSession.createQuery("from Users us where us.edad >= "+edad).getResultList();
			
			for (Users userResponseTmp:userResponseList) {
				UserResponse userResponse = new UserResponse();
				userResponse.setId(userResponseTmp.getId());
				userResponse.setFirstName(userResponseTmp.getNombre());
				userResponse.setLastName(userResponseTmp.getApellido());
				userResponse.setDocumentType(userResponseTmp.getTipoDoc());
				userResponse.setDocumentNumber(userResponseTmp.getNumdoc());
				userResponse.setEdad(userResponseTmp.getEdad());
				userResponse.setCiudadNacimiento(userResponseTmp.getCiudadNacimiento());
				
				userResponseOutList.add(userResponse);
				
			}
			miSession.getTransaction().commit();
			miSession.close();
			
		}finally {
			miFactory.close();
		}
		
		return userResponseOutList;
	}
	
	@Override
	public List<UserResponse> getAllUsers(int page,int limit){
		
		List<UserResponse> userResponseOutList = new ArrayList<UserResponse>();
		List<Users> userResponseList;
		SessionFactory miFactory = new Configuration().configure(dbConexionSource).addAnnotatedClass(Users.class).buildSessionFactory();
		Session miSession = miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			userResponseList = miSession.createQuery(" from Users").setMaxResults(limit).getResultList();
			
			for (Users userResponseTmp:userResponseList) {
				UserResponse userResponse = new UserResponse();
				userResponse.setId(userResponseTmp.getId());
				userResponse.setFirstName(userResponseTmp.getNombre());
				userResponse.setLastName(userResponseTmp.getApellido());
				userResponse.setDocumentType(userResponseTmp.getTipoDoc());
				userResponse.setDocumentNumber(userResponseTmp.getNumdoc());
				userResponse.setEdad(userResponseTmp.getEdad());
				userResponse.setCiudadNacimiento(userResponseTmp.getCiudadNacimiento());
				
				userResponseOutList.add(userResponse);
				
			}
			miSession.getTransaction().commit();
			miSession.close();
			
		}finally {
			miFactory.close();
		}
		
		return userResponseOutList;
	}
}
