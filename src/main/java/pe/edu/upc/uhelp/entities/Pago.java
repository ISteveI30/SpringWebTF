package pe.edu.upc.uhelp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pagos")
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPago;
	
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
		
	public Pago() {
		super();
	}
	/*	
	public Pago(String aux) {
		super();
		this.nombre = aux;
	}*/


	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/*
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getCodigoTarjeta() {
		return codigoTarjeta;
	}

	public void setCodigoTarjeta(String codigoTarjeta) {
		this.codigoTarjeta = codigoTarjeta;
	}

	public String getCodigoPresencial() {
		return codigoPresencial;
	}

	public void setCodigoPresencial(String codigoPresencial) {
		this.codigoPresencial = codigoPresencial;
	}
			*/
}
