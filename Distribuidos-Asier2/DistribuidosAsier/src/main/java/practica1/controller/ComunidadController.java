package practica1.controller;

import java.util.List;

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
	
	@RequestMapping("/consultarcomunidad")
	public String consultarComunidad (Model model){
		
		model.addAttribute("comunidad", repCom.findAll());
		model.addAttribute("propiedad", repPro.findAll());
		
		return "consultarcomunidad";
	}
	
	@RequestMapping("/busquedacif")
	public String busquedaCif (@RequestParam (value="cif") String cif,Model model){
		
		
		model.addAttribute("portal", repCom.findByCif(cif));
		
		return "consultarcomunidad";
	}
	
	@RequestMapping("/busquedacp")
	public String busquedaCp (@RequestParam (value="cp") int cp,Model model){
		
		
		model.addAttribute("portal", repCom.findByCodigopostal(cp));
		
		return "consultarcomunidad";
	}
	
	@RequestMapping("/busquedapoblacion")
	public String busquedaPoblacion (@RequestParam (value="poblacion") String poblacion,Model model){
		
		
		model.addAttribute("portal", repCom.findByPoblacion(poblacion));
		
		return "consultarcomunidad";
	}
	
	@RequestMapping("/busquedacuenta")
	public String busquedaCuenta (@RequestParam (value="cuenta") long cuenta,Model model){
		
		
		model.addAttribute("portal", repCom.findByCuentabancaria(cuenta));
		
		return "consultarcomunidad";
	}
	
	@RequestMapping("/busquedacalle")
	public String busquedaCalle (@RequestParam (value="calle") String calle,Model model){
		
		
		model.addAttribute("portal", repCom.findByCalle(calle));
		
		return "consultarcomunidad";
	}
	
	@RequestMapping("/busquedanumero")
	public String busquedaNumero (@RequestParam (value="numero") int numero,Model model){
		
		
		model.addAttribute("portal", repCom.findByNumero(numero));
		
		return "consultarcomunidad";
	}
	
	@RequestMapping("/eliminarcomunidad")
	public String eliminar (){
	
		return "eliminarcomunidad";
	}
	
	@RequestMapping("/confirmareliminacioncomunidad")
	public String confirmareliminar (@RequestParam (value="cif") String cif, Model model){
		List <Propiedad> pro = repPro.findByPertenecea(cif);
		repPro.delete(pro);
		List <Comunidad> com = repCom.findByCif(cif);
		repCom.delete(com);
		
		model.addAttribute("comunidad", repCom.findAll());
		model.addAttribute("propiedad", repPro.findAll());
		return "/index";
	}
	
	@RequestMapping("/modificarcomunidad")
	public String modificar (){
	
		return "modificarcomunidad";
	}
	
	@RequestMapping("/confirmarmodificacioncomunidad")
	public String confirmarModificar (@RequestParam (value="cif") String cif,@RequestParam (value="cp") int cp,@RequestParam (value="poblacion") String poblacion,@RequestParam (value="cuenta") long cuenta,@RequestParam (value="calle") String calle,@RequestParam (value="numero") int numero, Model model){
		Comunidad com = repCom.findOne(cif);
		if (cp!=0){
			com.setCodigopostal(cp);
		}
		if (!(poblacion.equals(""))){
			com.setPoblacion(poblacion);
		}
		if (cuenta!=0){
			com.setCuentabancaria(cuenta);
		}
		if (!(calle.equals(""))){
			com.setCalle(calle);
		}
		if (numero!=0){
			com.setNumero(numero);
		}
		
		repCom.flush();

		
		model.addAttribute("comunidad", repCom.findAll());
		model.addAttribute("propiedad", repPro.findAll());
		return "/index";
		
		
	}
}
