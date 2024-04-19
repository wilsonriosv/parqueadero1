package com.parqueadero1.backend.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.parqueadero1.backend.models.dao.IParqueoDAO;
import com.parqueadero1.backend.models.entity.Parqueo;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ParqueoSeviceImpl implements IParqueoService {

	@Autowired
	private IParqueoDAO parqueoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Parqueo> findAll() {
		return (List<Parqueo>) parqueoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Parqueo findById(Long id) {
		// Verifica si el parqueo existe en la base de datos
	    Parqueo existingParqueo = parqueoDAO.findById(id)
	        .orElseThrow(() -> new EntityNotFoundException("ID no encontrado"));

		return parqueoDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Parqueo save(Parqueo parqueo) {
		// TODO realizar la validación si es necesaria
		return parqueoDAO.save(parqueo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		parqueoDAO.deleteById(id);
	}

	@Override
	@Transactional
	public Parqueo update(Parqueo parqueo) {
		// Verifica si el parqueo existe en la base de datos
	    Parqueo existingParqueo = parqueoDAO.findById(parqueo.getId())
	        .orElseThrow(() -> new EntityNotFoundException("Parqueo no encontrado"));

	    // Actualiza los campos del parqueo existente con los valores del parqueo proporcionado
	    existingParqueo.setTotalPagado(parqueo.getTotalPagado());
	    existingParqueo.setPlaca(parqueo.getPlaca());
	    existingParqueo.setFechaHoraIngreso(parqueo.getFechaHoraIngreso());
	    existingParqueo.setFechaHoraSalida(parqueo.getFechaHoraSalida());
	    // Añade aquí cualquier otro campo que necesites actualizar

	    // Guarda el parqueo actualizado en la base de datos
	    return parqueoDAO.save(existingParqueo);
	}

	@Override
	@Transactional(readOnly=true)
	public Parqueo findByPlaca(String placa) {
		// Verifica si el parqueo existe en la base de datos
	    Parqueo existingParqueo = parqueoDAO.findByPlaca(placa);
	      //.orElseThrow(() -> new EntityNotFoundException("PLACA no encontrado"));
	    if (existingParqueo==null) {
	    	throw new EntityNotFoundException("PLACA no encontrado");
	    }
	    
		return parqueoDAO.findByPlaca(placa);
	}

}
