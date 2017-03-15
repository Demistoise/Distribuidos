package practica1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Propiedad {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private	Propietario propietario;
	
	private Integer numpostal;
	private Integer numeroletra;
	
	public Propiedad() {
		
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Integer getNumpostal() {
		return numpostal;
	}

	public void setNumpostal(Integer numpostal) {
		this.numpostal = numpostal;
	}

	public Integer getNumeroletra() {
		return numeroletra;
	}

	public void setNumeroletra(Integer numeroletra) {
		this.numeroletra = numeroletra;
	}
	
	
}
