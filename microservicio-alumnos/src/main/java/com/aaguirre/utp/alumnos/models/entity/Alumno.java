package com.aaguirre.utp.alumnos.models.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombres;
	
	@Column(name = "apelido_paterno")
	private String apellidoPaterno;
	
	@Column(name = "apelido_materno")
	private String apellidoMaterno;
	
	@Column(name = "f_nacimiento")
	private LocalDate fechaDeNacimiento;
	
	@Column(name = "f_registro")
	private LocalDateTime fechaDeRegistro;
	
	private String matricula;
	private String sexo;
	private String curp;
	
	
	@PrePersist
	public void prePersist() {
		this.fechaDeRegistro = LocalDateTime.now();
	}
	
	public Alumno(Long id, String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaDeNacimiento,
			LocalDateTime fechaDeRegistro, String matricula, String sexo, String curp) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.fechaDeRegistro = fechaDeRegistro;
		this.matricula = matricula;
		this.sexo = sexo;
		this.curp = curp;
	}
	
	
	
	public Alumno() {}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public LocalDateTime getFechaDeRegistro() {
		return fechaDeRegistro;
	}
	public void setFechaDeRegistro(LocalDateTime fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	
	
	
}
