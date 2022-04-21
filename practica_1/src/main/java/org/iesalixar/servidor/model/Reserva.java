package org.iesalixar.servidor.model;

import java.io.Serializable;

public class Reserva implements Serializable {
	String inicio;
	String fin;
	Integer personas;
	String[] servicios;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getInicio() {
		return inicio;
	}



	public void setInicio(String inicio) {
		this.inicio = inicio;
	}



	public String getFin() {
		return fin;
	}



	public void setFin(String fin) {
		this.fin = fin;
	}



	public Integer getPersonas() {
		return personas;
	}



	public void setPersonas(Integer personas) {
		this.personas = personas;
	}



	public String[] getServicios() {
		return servicios;
	}



	public void setServicios(String[] servicios) {
		this.servicios = servicios;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
