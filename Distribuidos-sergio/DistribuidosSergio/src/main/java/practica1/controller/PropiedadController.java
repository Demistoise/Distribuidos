package practica1.controller;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
		
		Propiedad pro1 = new Propiedad ("PEPE","PEREZ","78945612K","CALLE LAS ESPINAS",987654321,"785452F",5,"A",5,56478912);
		Propiedad pro2 = new Propiedad ("NACHO","SERRANO","32165478L","CALLE LAS ESPINAS",564213589,"785452F",5,"B",7,56845712);
		Propiedad pro3 = new Propiedad ("JOSE","MARTIN","15975364J","CALLE LAS ESPINAS",123547864,"755452F",3,"B",4,56457891);
		
		repPro.save(pro1);
		repPro.save(pro2);
		repPro.save(pro3);
		
		
	}

	@RequestMapping(value="/")
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
