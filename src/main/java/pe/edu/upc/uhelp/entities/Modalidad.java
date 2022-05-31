package pe.edu.upc.uhelp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Modalidades")
public class Modalidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idModalidad;
	
	@Column(name = "formato", nullable = false, length = 30)
	private String formato;
	
	@Column(name = "tipo", nullable = false, length = 30)
	private String tipo;
	
	@Column(name = "duracion", nullable = false, length = 30)
	private String duracion;

	public Modalidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Modalidad(int idModalidad, String formato, String tipo, String duracion) {
		super();
		this.idModalidad = idModalidad;
		this.formato = formato;
		this.tipo = tipo;
		this.duracion = duracion;
	}

	public int getIdModalidad() {
		return idModalidad;
	}

	public void setIdModalidad(int idModalidad) {
		this.idModalidad = idModalidad;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	
	
}
