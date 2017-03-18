package practica1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
public class Propiedad {
	
	private String nombre;
	private String apellidos;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String dni;
	
	private String direccion;
	private int telefono;
	
	private String pertenecea;
	
	private int planta;
	private String letra;
	private int porcentaje;
	private int numcuentabancaria;
	
	public Propiedad (){
		
	}
	
	public Propiedad (String nombre, String apellidos, String dni, String direccion, int telefono, String pertenecea, int planta, String letra, int porcentaje, int numcuentabancaria){
		this.nombre = nombre;
		this.apellidos=apellidos;
		this.dni=dni;
		this.direccion=direccion;
		this.telefono=telefono;
		this.pertenecea=pertenecea;
		this.planta=planta;
		this.letra=letra;
		this.porcentaje=porcentaje;
		this.numcuentabancaria=numcuentabancaria;
		
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getPlanta() {
		return planta;
	}
	public void setPlanta(int planta) {
		this.planta = planta;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public int getNumcuentabancaria() {
		return numcuentabancaria;
	}
	public void setNumcuentabancaria(int numcuentabancaria) {
		this.numcuentabancaria = numcuentabancaria;
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	

	
	@Override
	public String toString() {
		return "Propiedad [Nombre=" + nombre + ", Apellidos=" + apellidos + ", DNI=" + dni + ", Direccion="
				+ direccion + ", Telefono=" + telefono + ", Pertenece a=" + pertenecea + ", Planta=" + planta + ", Letra=" + letra + ", Porcentaje=" + porcentaje + ", Numero de Cuenta=" + numcuentabancaria + "]";
	}
	public void setPertenecea(String pertenecea) {
		this.pertenecea = pertenecea;
	}
	public String getPertenecea() {
		return pertenecea;
	}
	
	
}
