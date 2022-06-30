package pe.edu.upc.uhelp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Promociones")
public class Promocion{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPromocion;
	
	//@NotEmpty(message = "Ingrese el titulo de la Promocion*")
	@Column(name = "titulo", nullable = false, length = 30)
	private String titulo;
	
	//@NotEmpty(message = "Ingrese la descripción de la Promocion*")
	@Column(name = "descripcion", nullable = false, length = 200)
	private String descripcion;
	
	
	
	/*@ManyToOne
    @JoinColumn(name="idAcademia")
    private Academia academia;*/
	
	@ManyToOne
    @JoinColumn(name="idCurso")
    private Curso curso;

	public Promocion() {
		super();
	}

	public int getIdPromocion() {
		return idPromocion;
	}

	public void setIdPromocion(int idPromocion) {
		this.idPromocion = idPromocion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
