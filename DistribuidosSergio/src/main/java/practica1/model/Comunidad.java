package practica1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Comunidad {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@OneToMany(mappedBy = "pertenecea")
	private List<Propiedad> cif;
	
	private  int codigopostal;
	private String poblacion;
	private int cuentabancaria;
	private String calle;
	private int numero;
	


	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public int getCuentabancaria() {
		return cuentabancaria;
	}
	public void setCuentabancaria(int cuentabancaria) {
		this.cuentabancaria = cuentabancaria;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public List<Propiedad> getCif() {
		return cif;
	}
	public void setCif(List<Propiedad> cif) {
		this.cif = cif;
	}
	
	public int getCodigopostal() {
		return codigopostal;
	}
	public void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}
	
	@Override
	public String toString() {
		return "Comunidad [cif=" + cif + ", CP=" + codigopostal + ", Poblacion=" + poblacion + ", Cuenta Bancaria="
				+ cuentabancaria + ", Calle=" + calle + ", Numero=" + numero + "]";
	}
	
	
	
}
