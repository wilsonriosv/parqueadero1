package com.parqueadero1.backend.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.parqueadero1.backend.models.entity.Parqueo;

@Repository
public interface IParqueoDAO extends CrudRepository<Parqueo, Long> {

	public Parqueo findByPlaca(String placa);
	
}
