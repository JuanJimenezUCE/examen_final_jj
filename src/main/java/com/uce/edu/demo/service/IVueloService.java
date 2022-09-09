package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface IVueloService {

	public Vuelo buscarVuelosDisponibles(String origen, String destino, String fechaVuelo);
	
	public Vuelo buscarPorNumero(Integer numero);
	
	public void actualizar(Vuelo vuelo);
}
