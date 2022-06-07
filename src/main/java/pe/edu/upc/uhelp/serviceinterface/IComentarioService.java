package pe.edu.upc.uhelp.serviceinterface;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.Comentario;
public interface IComentarioService {
	public void insert(Comentario comentario);

	public List<Comentario> list();

	public void delete(int idcomentario);

	Optional<Comentario> findComentario(int idcomentario);

	public void update(Comentario comentario);
}
