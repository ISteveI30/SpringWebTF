package pe.edu.upc.uhelp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Docentes")
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDocente;
	
	@NotEmpty(message = "Ingrese el nombre del Docente*")
	@Column(name = "nombre", nullable = false, length = 30)
	private String nombre;
	
	@NotEmpty(message = "Ingrese el apellido del Docente*")
	@Column(name = "apellido", nullable = false, length = 30)
	private String apellido;
	
	@Column(name = "dni", nullable = false, length = 30)
	private String dni;
	
	
	
	@Column(name = "puntaje", nullable = false)
	private int puntaje;

	@ManyToOne
    @JoinColumn(name="idAcademia")
    private Academia academia;
	
	@ManyToOne
    @JoinColumn(name="idCurso")
    private Curso curso;

	public Docente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Docente(int idDocente, String nombre, String apellido, String dni, int puntaje, Academia academia,
			Curso curso) {
		super();
		this.idDocente = idDocente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.puntaje = puntaje;
		this.academia = academia;
		this.curso = curso;
	}

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

	public Academia getAcademia() {
		return academia;
	}

	public void setAcademia(Academia academia) {
		this.academia = academia;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}