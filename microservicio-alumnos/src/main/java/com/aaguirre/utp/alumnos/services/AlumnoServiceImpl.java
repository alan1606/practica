package com.aaguirre.utp.alumnos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaguirre.utp.alumnos.models.entity.Alumno;
import com.aaguirre.utp.alumnos.models.repository.AlumnoRepository;


@Service
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Override
	public Alumno guardar(Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@Override
	public void eliminar(Long id) {
		alumnoRepository.deleteById(id);
	}

	@Override
	public Optional<Alumno> encontrarPorId(Long id) {
		return alumnoRepository.findById(id);
	}

	@Override
	public Iterable<Alumno> encontrarTodo() {
		return alumnoRepository.findAll();
	}

	@Override
	public Optional<Alumno> encontrarPorMatricula(String matricula) {
		return alumnoRepository.encontrarPorMatricula(matricula);
	}

}
