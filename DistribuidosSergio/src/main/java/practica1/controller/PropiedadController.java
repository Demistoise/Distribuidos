package practica1.controller;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import practica1.model.Comunidad;
import practica1.model.Propiedad;
import practica1.repository.ComunidadRepository;
import practica1.repository.PropiedadRepository;

@Controller
public class PropiedadController {
	@Autowired
	private ComunidadRepository repCom;
	
	@Autowired
	private PropiedadRepository repPro;
	
	
	
	@PostConstruct
	public void init(){
		Comunidad com = new Comunidad ("785452F",28921,"ALCORCON",789456123,"CALLE LAS ESPINAS",3);
		Comunidad com2 = new Comunidad ("775452F",28921,"ALCORCON",759556123,"CALLE LAS ESPINAS",7);
		Comunidad com3 = new Comunidad ("755452F",22921,"MOSTOLES",779756123,"CALLE LAS ESPINAS",9);
		
		repCom.save(com);
		repCom.save(com2);
		repCom.save(com3);
		
		Propiedad pro1 = new Propiedad ();
		Propiedad pro2 = new Propiedad ();
		Propiedad pro3 = new Propiedad ();
		
		repPro.save(pro1);
		repPro.save(pro2);
		repPro.save(pro3);
		
		
	}

	@RequestMapping("/")
	public String principal (Model model){
		
		model.addAttribute("comunidad", repCom.findAll());
		
		return "index";
	}
	
	@RequestMapping("/insertarPropiedad")
	public String insertarPropiedad (Propiedad pro, Model model){
		
		repPro.save(pro);
		
		return "index";
	}
	
	
	
	
}
