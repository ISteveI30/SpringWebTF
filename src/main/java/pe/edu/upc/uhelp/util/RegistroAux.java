package pe.edu.upc.uhelp.util;

import pe.edu.upc.uhelp.entities.Estudiante;

public class RegistroAux {

	private Estudiante student;
	
	private int idAcademy;
	
	private String nombre;

	private String apellido;

	private String correo;

	private int sede;

	private String telefono;

	private String rol;

	private String password;

	//private String nickname;

	/*public RegistroAux() {
		super();
		this.rol="ROLE_USER";
	}*/

	public RegistroAux() {
		super();
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

	public int getSede() {
		return sede;
	}

	public void setSede(int sede) {
		this.sede = sede;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdAcademy() {
		return idAcademy;
	}

	public void setIdAcademy(int idAcademy) {
		this.idAcademy = idAcademy;
	}

	public Estudiante getStudent() {
		return student;
	}

	public void setStudent(Estudiante student) {
		this.student = student;
	}

	/*public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}*/
}
