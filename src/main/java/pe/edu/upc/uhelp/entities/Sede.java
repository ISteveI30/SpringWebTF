package pe.edu.upc.uhelp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sedes")
public class Sede {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSede;
	
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	@Column(name="direccion", nullable = false, length= 55)
	private String direccion;
	
	@Column(name="distrito", nullable = false, length= 40)
	private String distrito;

	public Sede() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sede(int idSede, String nombre, String direccion, String distrito) {
		super();
		this.idSede = idSede;
		this.nombre = nombre;
		this.direccion = direccion;
		this.distrito = distrito;
	}

	public int getIdSede() {
		return idSede;
	}

	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	
}
