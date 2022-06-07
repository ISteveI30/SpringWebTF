package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.Promocion;

public interface IPromocionService {

	public void insert(Promocion promocion);

	public List<Promocion> list();

	public void delete(int idPromocion);

	Optional<Promocion> findModalidad(int idPromocion);

	public void update(Promocion promocion);
}
