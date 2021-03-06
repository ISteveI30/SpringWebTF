package pe.edu.upc.uhelp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Docentes")
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDocente;
	
	@NotEmpty(message = "Ingrese el nombre del Docente")
	@Column(name = "nombre", length = 30)
	private String nombre;
	
	@NotEmpty(message = "Ingrese el apellido del Docente")
	@Column(name = "apellido", length = 30)
	private String apellido;
	
	@NotEmpty(message = "Ingrese el DNI del Docente")
	@Column(name = "dni", length = 30)
	private String dni;
	
	@Column(name = "puntaje", nullable = true)
	private int puntaje;

	/*@ManyToOne
    @JoinColumn(name="idAcademia")
    private Academia academia;*/

	public Docente() {
		super();
	}

	/*public Docente(int idDocente, String nombre, String apellido, String dni, int puntaje, Academia academia) {
		super();
		this.idDocente = idDocente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.puntaje = puntaje;
		this.academia = academia;
	}*/

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	/*public Academia getAcademia() {
		return academia;
	}

	public void setAcademia(Academia academia) {
		this.academia = academia;
	}*/
	
}