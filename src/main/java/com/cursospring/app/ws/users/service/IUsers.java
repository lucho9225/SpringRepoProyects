package com.cursospring.app.ws.users.service;

public interface IUsers {

	public String getNombre();

	public void setNombre(String nombre);

	public String getApellido();

	public void setApellido(String apellido);

	public String getTipoDoc();

	public void setTipoDoc(String tipoDoc);

	public String getNumdoc();

	public void setNumdoc(String numdoc);

	public int getEdad();

	public void setEdad(int edad);

	public String getCiudadNacimiento();

	public void setCiudadNacimiento(String ciudadNacimiento);

	public long getId();

	public void setId(long id);

	public String toString();

}
