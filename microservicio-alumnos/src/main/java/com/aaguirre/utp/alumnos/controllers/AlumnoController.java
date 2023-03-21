package com.aaguirre.utp.alumnos.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaguirre.utp.alumnos.models.entity.Alumno;
import com.aaguirre.utp.alumnos.services.AlumnoService;

@RestController
@RequestMapping("alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	
	@GetMapping
	public ResponseEntity<?> obtenerTodo(){
		return ResponseEntity.ok(alumnoService.encontrarTodo());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> encontrarPorId(@PathVariable(name = "id") Long id){
		Optional<Alumno> alumno = alumnoService.encontrarPorId(id);

		if(alumno.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(alumno.get());
	}
	
	@PostMapping
	public ResponseEntity<?> registrar(@RequestBody Alumno alumno){
		return ResponseEntity.ok(alumnoService.guardar(alumno));
	} 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarPorId(@PathVariable(name = "id") Long id){
		Optional<Alumno> alumno = alumnoService.encontrarPorId(id);

		if(alumno.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		alumnoService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificar(@PathVariable(name = "id") Long id, @RequestBody Alumno alumno){
		Optional<Alumno> a = alumnoService.encontrarPorId(id);

		if(a.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Alumno alumnoDb = a.get();
		
		alumnoDb.setNombres(alumno.getNombres());
		alumnoDb.setApellidoMaterno(alumno.getApellidoMaterno());
		alumnoDb.setApellidoPaterno(alumno.getApellidoPaterno());
		alumnoDb.setCurp(alumno.getCurp());
		alumnoDb.setFechaDeNacimiento(alumno.getFechaDeNacimiento());
		alumnoDb.setMatricula(alumno.getMatricula());
		alumnoDb.setSexo(alumno.getSexo());
		
		return ResponseEntity.ok(alumnoService.guardar(alumnoDb));
	}
	
	
	@GetMapping("/matricula/{matricula}")
	public ResponseEntity<?> encontrarPorMatricula(@PathVariable(name = "matricula") String matricula){
		Optional<Alumno> alumno = alumnoService.encontrarPorMatricula(matricula);
		
		if(alumno.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(alumno.get());
	}
}


