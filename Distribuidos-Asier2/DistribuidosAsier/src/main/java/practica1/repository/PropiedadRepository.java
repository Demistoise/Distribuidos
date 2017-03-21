package practica1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.Comunidad;
import practica1.model.Propiedad;

public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {
	Propiedad findByNombre (String nombre);
	
	
	Propiedad findByLetra (String letra);
	Propiedad findByPorcentaje (int porcentaje);
	Propiedad findByNumcuentabancaria (long numcuentabancaria);
	List <Propiedad> findById (int id);
	
	List <Propiedad> findByPortal (int portal);
	List <Propiedad> findByDni (String dni);
	List <Propiedad> findByPortalAndPlanta(int portal, int num);
	List <Propiedad> findByPertenecea (String pertenecea);
	List <Propiedad> findByApellidos (String apellidos);
	



}
