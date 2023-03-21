package com.aaguirre.utp.alumnos.models.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aaguirre.utp.alumnos.models.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long>{

	@Query("select a from Alumno a where a.matricula = ?1 ")
	public Optional<Alumno> encontrarPorMatricula(String matricula);
	
}
