package dam2.carreras.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dam2.carreras.model.Carrera;
import dam2.carreras.service.ICarreraService;

@RestController
@RequestMapping("carreras")
public class CarrerasController {
	
	@Autowired
	ICarreraService service;
	
	@GetMapping("/consultar")
	public ResponseEntity<List<Carrera>> consultarTodas() {
		List<Carrera> todas = service.buscarTodas().stream()
			.collect(Collectors.toList());
		
		return new ResponseEntity<>(todas, HttpStatus.OK);
	}
}
