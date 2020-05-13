package com.cursospring.app.ws.users.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursospring.app.ws.users.entity.UsersNoSql;
import com.cursospring.app.ws.users.repositories.UsersNoSqlRepository;
import com.cursospring.app.ws.users.request.UserRequestCreate;
import com.cursospring.app.ws.users.service.UserServiceMapper;
import com.cursospring.app.ws.users.service.UserServiceNoSql;

@Service
public class UserServiceNoSqlImpl implements UserServiceNoSql {

	@Autowired
	private UserServiceMapper mapper;
	
	private UsersNoSql userIn;
	
	@Autowired
	private UsersNoSqlRepository usersNoSQLRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	@Transactional
	public void saveUsersNoSQL(UserRequestCreate userRequest,String documentNumber) {
		
		userIn = mapper.mappUserNoSqlInCreate(userRequest,documentNumber);
		
		// TODO Auto-generated method stub
		usersNoSQLRepository.save(userIn);

	}

	@Override
	@Transactional
	public void deleteUser(UsersNoSql user) {
		// TODO Auto-generated method stub
		usersNoSQLRepository.deleteByNumdoc(user.getNumdoc());

	}

	@Override
	@Transactional
	public UsersNoSql findById(String numdoc) {
		// TODO Auto-generated method stub
		return usersNoSQLRepository.findByNumdoc(numdoc);
	}

	@Override
	@Transactional
	public List<UsersNoSql> findAll() {
		// TODO Auto-generated method stub
		return usersNoSQLRepository.findAll();
	}

	@Override
	@Transactional
	public UsersNoSql updateClientNoSQL(UsersNoSql user) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(user.getNumdoc()));
	    Update update = new Update();        
	    update.set("image", user.getImage());
	    
	    return mongoTemplate.findAndModify(query, update, UsersNoSql.class);
	}

}
