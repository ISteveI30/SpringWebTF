package pe.edu.upc.uhelp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FavoritoDocentes")
public class FavoritoDocente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idDocente")
	private Docente docente;
	
	/*@ManyToOne
	@JoinColumn(name="idEstudiante")
	private Estudiante estudiante;*/

	public FavoritoDocente() {
		super();
	}

	public FavoritoDocente(int id, Docente docente/*, Estudiante estudiante*/) {
		super();
		this.id = id;
		this.docente = docente;
		//this.estudiante = estudiante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
/*
	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}*/

}
