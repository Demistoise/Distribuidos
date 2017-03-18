package practica1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Comunidad {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String cif;
	
	private  int codigopostal;
	private String poblacion;
	private int cuentabancaria;
	private String calle;
	private int numero;
	

	public Comunidad(){
		
	}
	
	public Comunidad(String cif, int codigopostal, String poblacion, int cuentabancaria, String calle, int numero){
		this.cif=cif;
		this.codigopostal=codigopostal;
		this.poblacion=poblacion;
		this.cuentabancaria=cuentabancaria;
		this.calle=calle;
		this.numero=numero;
	}
	

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


	public String getCif() {
		return cif;
	}


	public void setCif(String cif) {
		this.cif = cif;
	}


	
	
	
}
