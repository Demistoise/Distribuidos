package practica1;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DistribuidosApplication {

	Connection con;
	Statement stat;
	ResultSet rs;
	
	public DistribuidosApplication (){
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:~/data","","");
			stat = con.createStatement();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
	
	
	void probar (){
		try {
			//stat.executeUpdate("DROP TABLE IF EXISTS comunidad");
			stat.executeUpdate("CREATE TABLE comunidad(cif VARCHAR(20) NOT NULL, cp INT NOT NULL, poblacion VARCHAR(20), cuentabancaria INT NOT NULL,calle VARCHAR(20), numero INT NOT NULL, PRIMARY KEY (cif))");
			stat.executeUpdate("CREATE TABLE propiedad(pertenece_a VARCHAR(20) NOT NULL, num INT NOT NULL, letra VARCHAR(20), nombre VARCHAR(20) NOT NULL, apellidos VARCHAR(20) NOT NULL, dni VARCHAR(20) NOT NULL, direccion VARCHAR(20) NOT NULL, telefono INT NOT NULL, cuenta INT NOT NULL, PRIMARY KEY (dni), FOREIGN KEY (pertenece_a) REFERENCES COMUNIDAD(cif))");
			stat.executeUpdate("INSERT INTO comunidad VALUES ('78954L',28921,'ALCORCON',879542361,'CALLE LOS ROSALES',3)");
			stat.executeUpdate("INSERT INTO propiedad VALUES ('78954L',3,'A','PEPE','PEREZ PACHECO','78961254N','CALLE LAS ESPINAS',921567485,569781125)");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	void consultaPertenece(){
		try {
			rs = stat.executeQuery("SELECT * FROM PROPIEDADES WHERE pertenece_a=");
			 while (rs.next()) {
		            System.out.println("Pertenece_a " + rs.getString("pertenece_a") + '\t' + "Planta: " + rs.getInt("num") + '\t' + "Letra: " + rs.getString("letra") + '\t' + "Nombre: " + rs.getString("nombre") + '\t' + "Apellidos: "+ rs.getString("apellidos") + '\t' + "DNI: " + rs.getString("dni") + '\t' + "Direccion: " + rs.getString("direccion") + '\t' + "Telefono: " + rs.getInt("telefono") + '\t' + "Cuenta: " + rs.getInt("cuenta"));
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	void consultaPerteneceMasPlanta(){
		try {
			rs = stat.executeQuery("SELECT * FROM PROPIEDADES WHERE (pertenece_a=) AND (num=)");
			while (rs.next()) {
	            System.out.println("Pertenece_a " + rs.getString("pertenece_a") + '\t' + "Planta: " + rs.getInt("num") + '\t' + "Letra: " + rs.getString("letra") + '\t' + "Nombre: " + rs.getString("nombre") + '\t' + "Apellidos: "+ rs.getString("apellidos") + '\t' + "DNI: " + rs.getString("dni") + '\t' + "Direccion: " + rs.getString("direccion") + '\t' + "Telefono: " + rs.getInt("telefono") + '\t' + "Cuenta: " + rs.getInt("cuenta"));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	void consultaApellidos(){
		try {
			rs = stat.executeQuery("SELECT * FROM PROPIEDADES WHERE apellidos=");
			while (rs.next()) {
	            System.out.println("Pertenece_a " + rs.getString("pertenece_a") + '\t' + "Planta: " + rs.getInt("num") + '\t' + "Letra: " + rs.getString("letra") + '\t' + "Nombre: " + rs.getString("nombre") + '\t' + "Apellidos: "+ rs.getString("apellidos") + '\t' + "DNI: " + rs.getString("dni") + '\t' + "Direccion: " + rs.getString("direccion") + '\t' + "Telefono: " + rs.getInt("telefono") + '\t' + "Cuenta: " + rs.getInt("cuenta"));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void consultaDni(){
		try {
			rs = stat.executeQuery("SELECT * FROM PROPIEDADES WHERE dni=");
			while (rs.next()) {
	            System.out.println("Pertenece_a " + rs.getString("pertenece_a") + '\t' + "Planta: " + rs.getInt("num") + '\t' + "Letra: " + rs.getString("letra") + '\t' + "Nombre: " + rs.getString("nombre") + '\t' + "Apellidos: "+ rs.getString("apellidos") + '\t' + "DNI: " + rs.getString("dni") + '\t' + "Direccion: " + rs.getString("direccion") + '\t' + "Telefono: " + rs.getInt("telefono") + '\t' + "Cuenta: " + rs.getInt("cuenta"));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void consultaTodo(){
		try {
			rs = stat.executeQuery("SELECT * FROM PROPIEDADES");
			while (rs.next()) {
	            System.out.println("Pertenece_a " + rs.getString("pertenece_a") + '\t' + "Planta: " + rs.getInt("num") + '\t' + "Letra: " + rs.getString("letra") + '\t' + "Nombre: " + rs.getString("nombre") + '\t' + "Apellidos: "+ rs.getString("apellidos") + '\t' + "DNI: " + rs.getString("dni") + '\t' + "Direccion: " + rs.getString("direccion") + '\t' + "Telefono: " + rs.getInt("telefono") + '\t' + "Cuenta: " + rs.getInt("cuenta"));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DistribuidosApplication.class, args);
	}
}
