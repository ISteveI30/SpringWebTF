package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.FavoritoDocente;

public interface IFavoritoDocenteService {

	public void insert(FavoritoDocente fdoc);

	public List<FavoritoDocente> list();

	public void delete(int idfdoc);

	Optional<FavoritoDocente> findOrden(int idfdoc);

	public void update(FavoritoDocente fdoc);
}
