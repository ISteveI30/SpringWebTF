package pe.edu.upc.uhelp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Carreras")
public class Carrera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCarrera;
	
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	@Column(name = "modalidad", nullable = false, length = 8)
	private String modalidad;
	
	public Carrera() {
		super();
	}

	public Carrera(int idCarrera, String nombre, String modalidad) {
		super();
		this.idCarrera = idCarrera;
		this.nombre = nombre;
		this.modalidad = modalidad;
		
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	
	
}
