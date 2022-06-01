package pe.edu.upc.uhelp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCurso;
	
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name = "inicio", nullable = false)
	private Date inicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name = "culminacion", nullable = false)
	private Date culminacion;
	
	@Column(name = "precio", nullable = false)
	private double precio;
	
	@Column(name = "vacantes", nullable = false, length = 3)
	private String vacantes;

	@ManyToOne
	@JoinColumn(name="idModalidad")
	private Modalidad modalidad;

	@ManyToOne
	@JoinColumn(name="idCarrera")
	private Carrera carrera;
		
	public Curso() {
		super();
	}

	public Curso(int idCurso, String nombre, Date inicio, Date culminacion, double precio, String vacantes,
			Modalidad modalidad, Carrera carrera) {
		super();
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.inicio = inicio;
		this.culminacion = culminacion;
		this.precio = precio;
		this.vacantes = vacantes;
		this.modalidad = modalidad;
		this.carrera = carrera;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getCulminacion() {
		return culminacion;
	}

	public void setCulminacion(Date culminacion) {
		this.culminacion = culminacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getVacantes() {
		return vacantes;
	}

	public void setVacantes(String vacantes) {
		this.vacantes = vacantes;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}	
		
}
