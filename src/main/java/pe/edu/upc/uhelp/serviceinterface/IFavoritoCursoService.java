package pe.edu.upc.uhelp.serviceinterface;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.FavoritoCurso;
public interface IFavoritoCursoService {
	public void insert(FavoritoCurso favoritoCurso);

	public List<FavoritoCurso> list();

	public void delete(int idfavoritoCurso);

	Optional<FavoritoCurso> findCurso(int idfavoritoCurso);

	public void update(FavoritoCurso favoritoCurso);
}
