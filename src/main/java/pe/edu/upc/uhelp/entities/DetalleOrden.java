package pe.edu.upc.uhelp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetalleOrdenes")
public class DetalleOrden {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDetalle;
	
	@Column(name = "precio", nullable = false)
	private double precio;
	
	@Column(name = "descuento", nullable = false)
	private double descuento;
	
	@ManyToOne
	@JoinColumn(name="idOrden")
	private Orden orden;
	
	@ManyToOne
	@JoinColumn(name="idCurso")
	private Curso curso;
	
	public DetalleOrden() {
		super();
	}

	public DetalleOrden(int idDetalle, double precio, double descuento, Orden orden, Curso curso) {
		super();
		this.idDetalle = idDetalle;
		this.precio = precio;
		this.descuento = descuento;
		this.orden = orden;
		this.curso = curso;
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
