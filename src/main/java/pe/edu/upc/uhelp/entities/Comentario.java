package pe.edu.upc.uhelp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Comentarios")
public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
<<<<<<< HEAD

	@Column(name = "descripcion", nullable = false, length = 200)
=======
	@NotEmpty(message= "Debe ingresar el contenido de su comentario*")
	@Column(name = "descripcion", nullable = false, length = 50)
>>>>>>> e491d57411583be1bb7b3dc39e8c48a4f5e9f8c9
	private String descripcion;
	
	/*@ManyToOne
	@JoinColumn (name="idAcademia")
	private Academia academia;
	
	@ManyToOne
	@JoinColumn (name="idEstudiante")
	private Estudiante estudiante;*/

	public Comentario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comentario(int id, String descripcion/*, Academia academia, Estudiante estudiante*/) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		/*this.academia = academia;
		this.estudiante = estudiante;*/
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/*public Academia getAcademia() {
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
	}*/
}
