package com.cursospring.app.ws.users.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cursospring.app.ws.users.entity.UsersNoSql;

@Repository
public interface UsersNoSqlRepository extends MongoRepository<UsersNoSql, Long> {
	/**
	 * findById o DeleteById, no funcionan por que en Mongo cuando se crea un documento, el id es
	 * asignado por el sistema automaticamente. 
	 */
	
	//Buscar en la DB de Mongo un Cliente por Numero de Identificacion
	public UsersNoSql findByNumdoc(String numdoc);
	
	//Eliminar un cliente de la DB de Monto por NUmero de Identificacion
	public void deleteByNumdoc(String numdoc);

}
