package practica1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import practica1.model.Comunidad;
import practica1.repository.ComunidadRepository;

public class ComunidadController {
	@Autowired
	private ComunidadRepository repCom;
	
	@RequestMapping("/insertarComunidad")
	public String insertarComunidad (Comunidad com, Model model){
		
		repCom.save(com);
		
		return "index";
	}
}
