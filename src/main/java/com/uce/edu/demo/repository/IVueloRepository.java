package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface IVueloRepository {

	public Vuelo buscarVuelosDisponibles(String origen, String destino, String fechaVuelo);
	
	public Vuelo buscarPorNumero(Integer numero);
	
	public void actualizar(Vuelo vuelo);
}
