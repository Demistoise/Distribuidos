package practica1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.Comunidad;



public interface ComunidadRepository extends JpaRepository<Comunidad, String> {

	List <Comunidad> findByCodigopostal (int codigopostal);
	List <Comunidad> findByPoblacion (String poblacion);
	List <Comunidad> findByCuentabancaria (long cuentabancaria);
	List <Comunidad> findByCalle (String calle);
	List <Comunidad> findByNumero  (int numero);
	
	List <Comunidad> findByCif (String cif);

}
