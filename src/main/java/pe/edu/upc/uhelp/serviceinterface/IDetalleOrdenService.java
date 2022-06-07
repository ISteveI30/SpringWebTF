package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.DetalleOrden;

public interface IDetalleOrdenService {
	public void insert(DetalleOrden dorden);

	public List<DetalleOrden> list();

	public void delete(int idorden);

	Optional<DetalleOrden> findOrden(int idorden);

	public void update(DetalleOrden dorden);
}
