package com.cursospring.app.ws.users.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.transaction.annotation.Transactional;

import com.cursospring.app.ws.users.service.UserServiceNoSql;
import com.cursospring.app.ws.users.service.UsersNoSqlRepository;

public class UserServiceNoSqlImpl implements UserServiceNoSql {

	@Autowired
	private UsersNoSqlRepository usersNoSQLRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void saveUsersNoSQL(UsersNoSql user) {
		// TODO Auto-generated method stub
		usersNoSQLRepository.save(user);

	}

	@Override
	@Transactional
	public void deleteUser(UsersNoSql user) {
		// TODO Auto-generated method stub
		usersNoSQLRepository.deleteByIdSql(user.getId());

	}

	@Override
	@Transactional
	public UsersNoSql findById(Long idSql) {
		// TODO Auto-generated method stub
		return usersNoSQLRepository.findByIdSql(idSql);
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
		query.addCriteria(Criteria.where("id").is(user.getId()));
	    Update update = new Update();        
	    update.set("image", user.getImage());
	    
	    return mongoTemplate.findAndModify(query, update, UsersNoSql.class);
	}

}
