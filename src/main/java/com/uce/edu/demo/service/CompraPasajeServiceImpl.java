package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.ICompraPasajeRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.CompraPasaje;
import com.uce.edu.demo.repository.modelo.Vuelo;

@Service

public class CompraPasajeServiceImpl implements ICompraPasajeService{

	@Autowired
	private ICompraPasajeRepository iCompraPasajeRepository;
	
	@Autowired
	private IVueloService iVueloService;
	
	@Autowired
	private IClienteRepository iClienteRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void reservar(Integer cantidadAsientos, String cedulaCliente, Vuelo vuelo) {
		// TODO Auto-generated method stub

		Cliente cliente =this.iClienteRepository.buscarPorCedula(cedulaCliente);
		
		
		CompraPasaje compraPasaje =  new CompraPasaje();
		compraPasaje.setEstado("RES");
		compraPasaje.setFechaCompra(LocalDateTime.now());
	    compraPasaje.setCliente(cliente);
		compraPasaje.setNumero("1");
		
		
		
		if (cantidadAsientos == vuelo.getAsientosDisponibles()) {
			compraPasaje.setCantidadAsientosComprados(cantidadAsientos);
			vuelo.setAsientosDisponibles(0);
			vuelo.setEstado("ND");
			
			
		}else if(cantidadAsientos < vuelo.getAsientosDisponibles()){
			vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles()-cantidadAsientos);
		    compraPasaje.setCantidadAsientosComprados(cantidadAsientos);
		}else {
			throw new RuntimeException();
			
		}

		compraPasaje.setVuelo(vuelo);
		this.iCompraPasajeRepository.insertar(compraPasaje);
		
		this.iVueloService.actualizar(vuelo);
		
		
		
	}

}
