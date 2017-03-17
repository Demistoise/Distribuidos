package practica1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.Comunidad;



public interface ComunidadRepository extends JpaRepository<Comunidad, Long> {

	Comunidad findByCodigopostal (int codigopostal);
	Comunidad findByPoblacion (String poblacion);
	Comunidad findByCuentabancaria (int cuentabancaria);
	Comunidad findByCalle (String calle);
	Comunidad findByNumero  (int numero);
}
