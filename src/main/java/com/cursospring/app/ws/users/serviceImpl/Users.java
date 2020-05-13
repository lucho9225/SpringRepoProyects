package com.cursospring.app.ws.users.serviceImpl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cursospring.app.ws.users.service.IUsers;

@Entity
@Table(name="users")
public class Users implements IUsers {

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

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getApellido() {
		return apellido;
	}

	@Override
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String getTipoDoc() {
		return tipoDoc;
	}

	@Override
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	@Override
	public String getNumdoc() {
		return numdoc;
	}

	@Override
	public void setNumdoc(String numdoc) {
		this.numdoc = numdoc;
	}

	@Override
	public int getEdad() {
		return edad;
	}

	@Override
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String getCiudadNacimiento() {
		return ciudadNacimiento;
	}

	@Override
	public void setCiudadNacimiento(String ciudadNacimiento) {
		this.ciudadNacimiento = ciudadNacimiento;
	}

	@Override
	public long getId() {
		return id;
	}
	
	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Users [nombre=" + nombre + ", apellido=" + apellido + ", tipoDoc=" + tipoDoc + ", numdoc=" + numdoc
				+ ", edad=" + edad + ", ciudadNacimiento=" + ciudadNacimiento + ", id=" + id + "]";
	}

}
