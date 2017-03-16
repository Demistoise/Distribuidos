package practica1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Propietario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private	String  NombreDNI;
	
	private Integer telefono;	
	private String  direccion;
	private String  cuentapropietario;
	private Integer gastoscomunidad;
	public String getNombreDNI() {
		return NombreDNI;
	}
	public void setNombreDNI(String nombreDNI) {
		NombreDNI = nombreDNI;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCuentapropietario() {
		return cuentapropietario;
	}
	public void setCuentapropietario(String cuentapropietario) {
		this.cuentapropietario = cuentapropietario;
	}
	public Integer getGastoscomunidad() {
		return gastoscomunidad;
	}
	public void setGastoscomunidad(Integer gastoscomunidad) {
		this.gastoscomunidad = gastoscomunidad;
	}
	
	
}
