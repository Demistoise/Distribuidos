package practica1.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/consultarpropiedad")
	public String consulta (){

		return "consultarpropiedad";
	}
	
	@RequestMapping("/busquedaportal")
	public String realizarConsultaPortal (@RequestParam (value="por") int por, Model model){
		List <Propiedad> bus = repPro.findByPortal(por);
		model.addAttribute("portal", bus);
		
		return "consultarpropiedad";
	}
	
	@RequestMapping("/busquedaportalplanta")
	public String realizarConsultaPortalPlanta (@RequestParam (value="por2") int por,@RequestParam (value="planta") int planta, Model model){
		List <Propiedad> bus = repPro.findByPortalAndPlanta(por,planta);
		model.addAttribute("portal", bus);
		
		return "consultarpropiedad";
	}
	
	@RequestMapping("/busquedaapellidos")
	public String realizarConsultaApellidos (@RequestParam (value="apellidos") String apellidos,Model model){
		List <Propiedad> bus = repPro.findByApellidos(apellidos);
		model.addAttribute("portal", bus);
		
		return "consultarpropiedad";
	}
	
	@RequestMapping("/busquedadni")
	public String realizarConsultaDni (@RequestParam (value="dni") String dni, Model model){
		List <Propiedad> bus = repPro.findByDni(dni);
		model.addAttribute("portal", bus);
		
		return "consultarpropiedad";
	}
	
	@RequestMapping("/busquedapertenece")
	public String realizarConsultaPertenece (@RequestParam (value="pertenecea") String pertenecea, Model model){
		List <Propiedad> bus = repPro.findByPertenecea(pertenecea);
		model.addAttribute("portal", bus);
		
		return "consultarpropiedad";
		
	}
	
	@RequestMapping("/eliminarpropiedad")
	public String eliminar (){
	
		return "eliminarpropiedad";
	}
	
	@RequestMapping("/confirmareliminacionpropiedad")
	public String confirmareliminar (@RequestParam (value="iden") int id, Model model){
		List <Propiedad> p = repPro.findById(id);
		repPro.delete(p);
		
		model.addAttribute("comunidad", repCom.findAll());
		model.addAttribute("propiedad", repPro.findAll());
		return "/index";
	}
	
	@RequestMapping("/modificarpropiedad")
	public String modificar (){
	
		return "modificarpropiedad";
	}
	
	@RequestMapping("/confirmarmodificacionpropiedad")
	public String confirmarModificar (@RequestParam (value="iden") Long id,@RequestParam (value="nombre") String nombre,@RequestParam (value="apellidos") String apellidos,@RequestParam (value="dni") String dni,@RequestParam (value="direccion") String direccion,@RequestParam (value="telefono") long telefono,@RequestParam (value="pertenece") String pertenece,@RequestParam (value="portal") int portal,@RequestParam (value="planta") int planta,@RequestParam (value="letra") String letra,@RequestParam (value="porcentaje") int porcentaje,@RequestParam (value="cuenta") long cuenta, Model model){
		Propiedad p = repPro.findOne(id);
		if (!(nombre.equals(""))){
			p.setNombre(nombre);
		}
		if (!(apellidos.equals(""))){
			p.setApellidos(apellidos);
		}
		if (!(dni.equals(""))){
			p.setDni(dni);
		}
		if (!(direccion.equals(""))){
			p.setDireccion(direccion);
		}
		if (telefono!=0){
			p.setTelefono(telefono);
		}
		if (!(pertenece.equals(""))){
			p.setPertenecea(pertenece);
		}
		if (portal!=0){
			p.setPortal(portal);
		}
		if (planta!=0){
			p.setPlanta(planta);
		}
		if (!(letra.equals(""))){
			p.setLetra(letra);
		}
		if (porcentaje!=0){
			p.setPorcentaje(porcentaje);
		}
		if (cuenta!=0){
			p.setNumcuentabancaria(cuenta);
		}
		
		repPro.flush();
		model.addAttribute("comunidad", repCom.findAll());
		model.addAttribute("propiedad", repPro.findAll());
		return "/index";
		
		
	}
	
	
	
	
	
	
}
