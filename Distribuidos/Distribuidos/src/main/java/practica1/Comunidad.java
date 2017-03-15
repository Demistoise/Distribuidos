package practica1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comunidad {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private	String  CIF;
	
	private Integer cpostal;
	private Integer poblacion;
	private String  cuentabancaria;
	private String  calle;
	private Integer numerocalle;
	
	public Comunidad(){
		
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public Integer getCpostal() {
		return cpostal;
	}

	public void setCpostal(Integer cpostal) {
		this.cpostal = cpostal;
	}

	public Integer getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Integer poblacion) {
		this.poblacion = poblacion;
	}

	public String getCuentabancaria() {
		return cuentabancaria;
	}

	public void setCuentabancaria(String cuentabancaria) {
		this.cuentabancaria = cuentabancaria;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumerocalle() {
		return numerocalle;
	}

	public void setNumerocalle(Integer numerocalle) {
		this.numerocalle = numerocalle;
	}
	
	
}
