package practica1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.model.Comunidad;
import practica1.model.Propiedad;

public interface PropiedadRepository extends JpaRepository<Propiedad, Long> {
	Propiedad findByNombre (String nombre);
	Propiedad findByApellidos (String apellidos);
	Propiedad findByPertenecea (Comunidad pertenecea);
	Propiedad findByPlanta (int num);
	Propiedad findByLetra (String letra);
	Propiedad findByPorcentaje (int porcentaje);
	Propiedad findByNumcuentabancaria (int numcuentabancaria);
	
	List<Propiedad> findByPerteneceaAndPlanta(Comunidad pertenecea, int num);
}
