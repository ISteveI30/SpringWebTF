package pe.edu.upc.uhelp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name = "Estudiantes")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstudiante;
	
	@NotEmpty(message= "Debe ingresar su nombre de Estudiante*")
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@NotEmpty(message= "Debe ingresar su apellido de Estudiante*")
	@Column(name = "apellido", nullable = false, length = 50)
	private String apellido;
	@NotEmpty(message= "Debe ingresar un correo electrónico*")
	@Column(name = "correo", nullable = false, length = 50)
	private String correo;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "estudiante")
	private Users user;

	public Estudiante() {
		super();
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
