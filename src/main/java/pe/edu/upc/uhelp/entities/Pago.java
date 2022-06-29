package pe.edu.upc.uhelp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*entidad de los pagos*/
@Entity
@Table(name = "Pagos")
public class Pago {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPago;
	
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	@Column(name = "numeroTarjeta", nullable = false, length = 16)
	private String numeroTarjeta;
	
	@Column(name = "codigoTarjeta", nullable = false, length = 3)
	private String codigoTarjeta;
	
	@Column(name = "codigoPresencial", nullable = false, length = 8)
	private String codigoPresencial;
		
	public Pago() {
		super();
	}
		
	public Pago(String aux) {
		super();
		this.nombre = aux;
	}

	public Pago(int idPago, String nombre, String numeroTarjeta, String codigoTarjeta, String codigoPresencial) {
		super();
		this.idPago = idPago;
		this.nombre = nombre;
		this.numeroTarjeta = numeroTarjeta;
		this.codigoTarjeta = codigoTarjeta;
		this.codigoPresencial = codigoPresencial;
	}

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
			
}
