package com.curso.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PresupuestoController {

	//asociamos m�todo a la petici�n HTTP
	@PostMapping(value="/calcular")
	public String calcularPresupuesto(@RequestParam("nombre") String nombre,
									@RequestParam("memoria") double memoria,
									@RequestParam("accesorio") double[] accesorios,
									@RequestParam("pago")  int descuento,
									  HttpServletRequest request) {
		double presupuesto=400;
		double acc=0;
		if(accesorios!=null) {
			for(double p:accesorios) {
				acc+=p;
			}
		}
		presupuesto+=(memoria+acc);
		presupuesto*=((100-descuento)/100.0);
		//Atributos de petici�n
		request.setAttribute("presupuesto", presupuesto);
		return "presupuesto";
	}
	
	/*@GetMapping(value="/volver")
	public String regreso() {
		return "configuracion";
	}*/
}
