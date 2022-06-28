package pe.edu.upc.uhelp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FavoritoCursos")
public class FavoritoCurso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn (name="idCurso")
	private Curso curso;
	
	/*@ManyToOne
	@JoinColumn (name="idEstudiante")
	private Estudiante estudiante;*/

	public FavoritoCurso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FavoritoCurso(Curso curso) {
		super();
		this.curso=curso;
		// TODO Auto-generated constructor stub
	}

	public FavoritoCurso(int id, Curso curso/*, Estudiante estudiante*/) {
		super();
		this.id = id;
		this.curso = curso;
		//this.estudiante = estudiante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/*public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}*/
}
