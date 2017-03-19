package practica1.controller;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		Propiedad pro1 = new Propiedad ("Pepe","Perez","78945612K","CALLE LAS ESPINAS",987654321,"785452F",3,5,"A",5,56478912);
		Propiedad pro2 = new Propiedad ("Nacho","Serrano","32165478L","CALLE LAS ESPINAS",564213589,"785452F",2,5,"B",7,56845712);
		Propiedad pro3 = new Propiedad ("Jose","Martin","15975364J","CALLE LAS ESPINAS",123547864,"755452F",4,3,"B",4,56457891);
		
		repPro.save(pro1);
		repPro.save(pro2);
		repPro.save(pro3);
		
		
	}

	@RequestMapping("/")
	public String principal (Model model){
		
		model.addAttribute("comunidad", repCom.findAll());
		model.addAttribute("propiedad", repPro.findAll());
		
		return "index";
	}
	
	@RequestMapping("/insertarPropiedad")
	public String insertarPropiedad (Propiedad pro, Model model){
		
		repPro.save(pro);
		model.addAttribute("comunidad", repCom.findAll());
		model.addAttribute("propiedad", repPro.findAll());
		
		return "index";
	}
	
	@RequestMapping("/anadirpro")
	public String anadirPropiedad (){

		return "anadirpropiedad";
	}
	
	@RequestMapping("/consultar")
	public String consulta (){

		return "consultar";
	}
	
	@RequestMapping("/busquedaportal")
	public String realizarConsultaPortal (@RequestParam (value="por") int por, Model model){
		List <Propiedad> bus = repPro.findByPortal(por);
		model.addAttribute("portal", bus);
		
		return "consultar";
	}
	
	@RequestMapping("/busquedaportalplanta")
	public String realizarConsultaPortalPlanta (@RequestParam (value="por2") int por,@RequestParam (value="planta") int planta, Model model){
		List <Propiedad> bus = repPro.findByPortalAndPlanta(por,planta);
		model.addAttribute("portal", bus);
		
		return "consultar";
	}
	
	@RequestMapping("/busquedaapellidos")
	public String realizarConsultaApellidos (@RequestParam (value="apellidos") String apellidos,Model model){
		List <Propiedad> bus = repPro.findByApellidos(apellidos);
		model.addAttribute("portal", bus);
		
		return "consultar";
	}
	
	@RequestMapping("/busquedadni")
	public String realizarConsultaDni (@RequestParam (value="dni") String dni, Model model){
		List <Propiedad> bus = repPro.findByDni(dni);
		model.addAttribute("portal", bus);
		
		return "consultar";
	}
	
	@RequestMapping("/busquedapertenece")
	public String realizarConsultaPertenece (@RequestParam (value="pertenecea") String pertenecea, Model model){
		List <Propiedad> bus = repPro.findByPertenecea(pertenecea);
		model.addAttribute("portal", bus);
		
		return "consultar";
		
	}
	
	@RequestMapping("/eliminar")
	public String eliminar (List<Propiedad> portal, Model model){
		repPro.delete(portal.get(0));
		
		return "consultar";
	}
	
	
	
	
	
	
}
