package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.FavoritoAcademia;

public interface IFavoritoAcademiaService {
	public void insert(FavoritoAcademia academia);

	public List<FavoritoAcademia> list();

	public void delete(int idacademia);

	Optional<FavoritoAcademia> findOrden(int idacademia);

	public void update(FavoritoAcademia academia);
}
