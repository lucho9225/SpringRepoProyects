package com.cursospring.app.ws.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class Users  {

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="tipo_doc")
	private String tipoDoc;
	
	@Column(name="num_doc")
	private String numdoc;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="ciudad_nacimiento")
	private String ciudadNacimiento;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	public Users() {
		super();
	}

	public Users(String nombre, String apellido, String tipoDoc, String numdoc, int edad, String ciudadNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.numdoc = numdoc;
		this.edad = edad;
		this.ciudadNacimiento = ciudadNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumdoc() {
		return numdoc;
	}

	public void setNumdoc(String numdoc) {
		this.numdoc = numdoc;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCiudadNacimiento() {
		return ciudadNacimiento;
	}

	public void setCiudadNacimiento(String ciudadNacimiento) {
		this.ciudadNacimiento = ciudadNacimiento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String toString() {
		return "Users [nombre=" + nombre + ", apellido=" + apellido + ", tipoDoc=" + tipoDoc + ", numdoc=" + numdoc
				+ ", edad=" + edad + ", ciudadNacimiento=" + ciudadNacimiento + ", id=" + id + "]";
	}

}
