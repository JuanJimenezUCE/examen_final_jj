package com.uce.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.to.CompraPasajeTo;
import com.uce.edu.demo.service.IVueloService;

@Controller
@RequestMapping("/vuelos")
public class VueloController {

	@Autowired
	private IVueloService iVueloService;
	@GetMapping("/listaVuelos")
	public String ListaVuelos() {
		
		
		return "listaVuelos";
	}
	@GetMapping("/reserva/{numero}")
	public String ReservarVuelo(@RequestParam(value="numero")String numero, Vuelo vuelo,Model model) {
		
		Vuelo vueloD = this.iVueloService.buscarPorNumero(vuelo.getNumero());
		
		model.addAttribute("vuelo", vueloD);
		model.addAttribute("compra", new CompraPasajeTo());
		
		return "vistaReservaVuelo";
	}
	
	
	@GetMapping("/buscarVuelo")
	public String buscarVuelo(Vuelo vuelo) {
		
		
		return "vistaVuelo";
	}
}
