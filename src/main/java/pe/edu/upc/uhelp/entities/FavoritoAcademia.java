package pe.edu.upc.uhelp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FavoritoAcademias")
public class FavoritoAcademia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idAcademia")
	private Academia academia;
	
	@ManyToOne
	@JoinColumn(name="idEstudiante")
	private Estudiante estudiante;

	public FavoritoAcademia() {
		super();
	}

	public FavoritoAcademia(int id, Academia academia, Estudiante estudiante) {
		super();
		this.id = id;
		this.academia = academia;
		this.estudiante = estudiante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Academia getAcademia() {
		return academia;
	}

	public void setAcademia(Academia academia) {
		this.academia = academia;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
}
