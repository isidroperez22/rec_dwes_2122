package org.iesalixar.servidor.model;

import java.io.Serializable;

public class Usuario implements Serializable {

	private String usuario;
	private String password;
	private String email;
	private String role;
	private String firstName;
	private String lastName;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Usuario(String usuario, String password, String email, String role, String firstName, String lastName) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
	}

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}	
	

}
