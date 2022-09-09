package com.uce.edu.demo.repository.modelo.to;

public class CompraPasajeTo {

private String numero;
	
	private Integer cantidadAsientos;
	
	private String cedula;
	
	public CompraPasajeTo() {
		
	}

	public CompraPasajeTo(String numero, Integer cantidadAsientos, String cedula) {
		super();
		this.numero = numero;
		this.cantidadAsientos = cantidadAsientos;
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return "PasajeTo [numero=" + numero + ", cantidadAsientos=" + cantidadAsientos + ", cedula=" + cedula + "]";
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}



	public Integer getCantidadAsientos() {
		return cantidadAsientos;
	}

	public void setCantidadAsientos(Integer cantidadAsientos) {
		this.cantidadAsientos = cantidadAsientos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	
	
}
