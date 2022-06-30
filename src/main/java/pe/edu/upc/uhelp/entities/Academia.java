package pe.edu.upc.uhelp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "academias")
public class Academia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAcademia;

	@NotEmpty(message = "Ingrese el nombre de la academia")
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@NotEmpty(message = "Ingrese un correo")
	@Column(name = "correo", nullable = false, length = 50)
	private String correo;

	@NotEmpty(message = "Ingrese un telefono")
	@Column(name = "telefono", nullable = false, length = 50)
	private String telefono;
	
	@ManyToOne
	@JoinColumn (name="idSede")
	private Sede sede;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "academia")
	private Users user;

	public Academia() {
		super();
	}

	public int getIdAcademia() {
		return idAcademia;
	}

	public void setIdAcademia(int idAcademia) {
		this.idAcademia = idAcademia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
