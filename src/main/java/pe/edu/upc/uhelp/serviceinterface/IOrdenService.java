package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.Orden;

public interface IOrdenService {

	public void insert(Orden orden);

	public List<Orden> list();

	public void delete(int idorden);

	Optional<Orden> findOrden(int idorden);

	public void update(Orden orden);
}
