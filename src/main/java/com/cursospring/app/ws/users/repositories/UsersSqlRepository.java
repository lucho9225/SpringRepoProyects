package com.cursospring.app.ws.users.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cursospring.app.ws.users.entity.Users;

@Repository
public interface UsersSqlRepository extends JpaRepository<Users, Long> {

	@Query(value = "SELECT * FROM users where tipo_doc = ?1 and num_doc=?2",nativeQuery = true )
	public List<Users> findByDoc(String tipoDoc , String numdoc);
	
	@Query(value = "SELECT * FROM users where edad > ?1",nativeQuery = true )
	public List<Users> findByAge(int edad );
	
	@Query(value = "SELECT * FROM users LIMIT ?1",nativeQuery = true )
	public List<Users> findWithLimit(int limit );
}
