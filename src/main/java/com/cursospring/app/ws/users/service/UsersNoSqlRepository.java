package com.cursospring.app.ws.users.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cursospring.app.ws.users.serviceImpl.UsersNoSql;

public interface UsersNoSqlRepository extends MongoRepository<UsersNoSql, Long> {
	/**
	 * findById o DeleteById, no funcionan por que en Mongo cuando se crea un documento, el id es
	 * asignado por el sistema automaticamente. 
	 */
	
	//Buscar en la DB de Mongo un Cliente por Numero de Identificacion
	public UsersNoSql findByIdSql(Long idSql);
	
	//Eliminar un cliente de la DB de Monto por NUmero de Identificacion
	public void deleteByIdSql(Long idSql);

}
