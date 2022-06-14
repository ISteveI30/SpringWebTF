package pe.edu.upc.uhelp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "roles" , uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id", "rol" }) })
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "rol", nullable = false, length = 50)
	private String rol;
	
	/*@ManyToOne(cascade = CascadeType.ALL)
	private Users user;*/

	public Rol() {
		super();
		//this.rol=rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	/*public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}*/
	
}
