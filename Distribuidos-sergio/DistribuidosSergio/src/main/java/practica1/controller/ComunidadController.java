package practica1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import practica1.model.Comunidad;
import practica1.repository.ComunidadRepository;
import practica1.repository.PropiedadRepository;

@Controller
public class ComunidadController {
	@Autowired
	private ComunidadRepository repCom;
	
	@Autowired
	private PropiedadRepository repPro;
	
	
	@RequestMapping("/anadircom")
	public String anadirCom (){
		
		return "anadircomunidad";
	}
	
	@RequestMapping("/insertarComunidad")
	public String insertarComunidad (Comunidad com, Model model){
		
		repCom.save(com);
		model.addAttribute("comunidad", repCom.findAll());
		model.addAttribute("propiedad", repPro.findAll());
		
		return "index";
	}
}
