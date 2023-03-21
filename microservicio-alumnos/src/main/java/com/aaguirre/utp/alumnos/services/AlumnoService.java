package com.aaguirre.utp.alumnos.services;

import java.util.Optional;

import com.aaguirre.utp.alumnos.models.entity.Alumno;

public interface AlumnoService {

	public Alumno guardar(Alumno alumno);
	
	public void eliminar(Long id);
	
	public Optional<Alumno> encontrarPorId(Long id);
	
	public Iterable<Alumno> encontrarTodo();
	
	public Optional<Alumno> encontrarPorMatricula(String matricula);
	
}
