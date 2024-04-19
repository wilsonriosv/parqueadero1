package com.parqueadero1.backend.models.services;

import java.util.List;

import com.parqueadero1.backend.models.entity.Parqueo;

public interface IParqueoService {

	public List<Parqueo> findAll();
	public Parqueo findById(Long id);
	public Parqueo save(Parqueo parqueo);
	public void delete(Long id);
	public Parqueo update(Parqueo parqueo);
	public Parqueo findByPlaca(String placa);
	
}
