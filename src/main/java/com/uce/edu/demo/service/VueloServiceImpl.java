package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVueloRepository;
import com.uce.edu.demo.repository.modelo.Vuelo;

@Service
public class VueloServiceImpl implements IVueloService{

	@Autowired
	private IVueloRepository iVueloRepository;
	
	@Override
	public Vuelo buscarVuelosDisponibles(String origen, String destino, String fechaVuelo) {
		// TODO Auto-generated method stub
		return this.iVueloRepository.buscarVuelosDisponibles(origen, destino, fechaVuelo);
	}

	@Override
	public Vuelo buscarPorNumero(Integer numero) {
		// TODO Auto-generated method stub
		return this.iVueloRepository.buscarPorNumero(numero);
	}

	@Override
	public void actualizar(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.iVueloRepository.actualizar(vuelo);
	}

}
