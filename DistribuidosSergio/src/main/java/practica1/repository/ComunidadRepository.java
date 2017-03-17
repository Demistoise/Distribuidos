package practica1.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.Comunidad;



public interface ComunidadRepository extends JpaRepository<Comunidad, String> {

	Comunidad findByCodigopostal (int codigopostal);
	Comunidad findByPoblacion (String poblacion);
	Comunidad findByCuentabancaria (int cuentabancaria);
	Comunidad findByCalle (String calle);
	Comunidad findByNumero  (int numero);

}
