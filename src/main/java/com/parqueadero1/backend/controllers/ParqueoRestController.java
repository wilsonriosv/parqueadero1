package com.parqueadero1.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.parqueadero1.backend.models.entity.Parqueo;
import com.parqueadero1.backend.models.services.IParqueoService;

@RestController
@RequestMapping("/api")
public class ParqueoRestController {

	@Autowired
	private IParqueoService parqueoService;
	
	//Consulta el listado de todos los parqueos
	@GetMapping("/parqueos")
    public List<Parqueo> index() {
        return parqueoService.findAll();
    }
	
	// Consulta un registro de parqueo por ID
	@GetMapping("/parqueos/{id}")
    public Parqueo show(@PathVariable Long id) {
        return parqueoService.findById(id);
    }
	
	// Consulta un registro de parqueo por PLACA
    @GetMapping("/parqueos/placa/{placa}")
    public Parqueo findByPlaca(@PathVariable String placa) {
        return parqueoService.findByPlaca(placa);
    }
    
    
	
}
