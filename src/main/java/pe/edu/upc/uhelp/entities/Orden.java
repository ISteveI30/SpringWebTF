package pe.edu.upc.uhelp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Ordenes")
public class Orden {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idOrden;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name = "fechaCompra", nullable = false)
	private Date fechaCompra;
	
	@ManyToOne
	@JoinColumn(name="idAcademia")
	private Academia academia;
	
	@ManyToOne
	@JoinColumn(name="idEstudiante")
	private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name="idPago")
	private Pago pago;

	public Orden() {
		super();
	}

	public Orden(int idOrden, Date fechaCompra, Academia academia, Estudiante estudiante, Pago pago) {
		super();
		this.idOrden = idOrden;
		this.fechaCompra = fechaCompra;
		this.academia = academia;
		this.estudiante = estudiante;
		this.pago = pago;
	}

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
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

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}
	
}
