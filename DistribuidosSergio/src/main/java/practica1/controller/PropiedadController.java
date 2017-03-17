package practica1.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import practica1.model.Propiedad;
import practica1.repository.ComunidadRepository;
import practica1.repository.PropiedadRepository;

@Controller
public class PropiedadController {
	@Autowired
	private ComunidadRepository repCom;
	
	@Autowired
	private PropiedadRepository repPro;
	
	Connection con;
	Statement stat;
	ResultSet rs;
	
	@PostConstruct
	public void init(){
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:~/data","","");
			stat = con.createStatement();
			try {
				if (rs ==stat.executeQuery(null)){
					stat.executeUpdate("CREATE TABLE comunidad(cif VARCHAR(20) NOT NULL, cp INT NOT NULL, poblacion VARCHAR(20), cuentabancaria INT NOT NULL,calle VARCHAR(20), numero INT NOT NULL, PRIMARY KEY (cif))");
					stat.executeUpdate("CREATE TABLE propiedad(pertenece_a VARCHAR(20) NOT NULL, num INT NOT NULL, letra VARCHAR(20), nombre VARCHAR(20) NOT NULL, apellidos VARCHAR(20) NOT NULL, dni VARCHAR(20) NOT NULL, direccion VARCHAR(20) NOT NULL, telefono INT NOT NULL, cuenta INT NOT NULL, PRIMARY KEY (dni), FOREIGN KEY (pertenece_a) REFERENCES COMUNIDAD(cif))");
					stat.executeUpdate("INSERT INTO comunidad VALUES ('78954L',28921,'ALCORCON',879542361,'CALLE LOS ROSALES',3)");
					stat.executeUpdate("INSERT INTO propiedad VALUES ('PEPE','PEREZ PACHECO','78952641V','CALLE LAS ESPINAS',921524678,'78954L',3,'A',7,7894523)");
				}
				//con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
