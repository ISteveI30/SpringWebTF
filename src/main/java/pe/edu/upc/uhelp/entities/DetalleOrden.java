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
	
	@Column(name = "cantidad")
	private int cantidad;

	@ManyToOne
	@JoinColumn(name="idCurso", nullable = true)
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="idPromocion", nullable = true)
	private Promocion promocion;
	
	public DetalleOrden() {
		super();
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Promocion getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}
}
