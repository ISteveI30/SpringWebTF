package pe.edu.upc.uhelp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username", unique = true, length = 50)
	private String username;
	
	@Column(name = "password", nullable = false, length = 200)
	private String password;
	
	@Column(name = "nickname", nullable = false, length = 50)
	private String nickname;

	private Boolean enabled;

	//@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAcademia", nullable = true)
	private Academia academia;
	
	//@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEstudiante", nullable = true)
	private Estudiante estudiante;

	@OneToMany(/*mappedBy = "user",*/fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Rol> roles;
	
	public Users() {
		super();
		this.enabled=true;
		this.roles = new ArrayList<>();
	}
	public void addRol(String rol) {
		Rol role=new Rol();
		role.setRol(rol);
		//role.setUser(this);
		this.roles.add(role);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
