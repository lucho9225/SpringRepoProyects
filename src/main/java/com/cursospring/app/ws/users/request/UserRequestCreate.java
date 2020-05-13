package com.cursospring.app.ws.users.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestCreate {
	
	@NotNull(message="El nombre del usuario es requerido")
	@Size(min=2,max=30)
	private String firstName;
	
	@NotNull(message="El apellido del usuario es requerido")
	@Size(min=2,max=30)
	private String lastName;
	
	@NotNull(message="El tipo de documento es requerido")
	@Size(min=2,max=3)
	private String documentType;
	
	@NotNull
	@Size(min=6,max=15)
	private String documentNumber;
	
	@NotNull
	private int edad;
	
	@NotNull
	private String ciudadNacimiento;
	
	private String image;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
