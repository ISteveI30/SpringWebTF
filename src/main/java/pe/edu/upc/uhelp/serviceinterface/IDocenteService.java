package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.Docente;

public interface IDocenteService {

	public void insert(Docente docente);

	public List<Docente> list();

	public void delete(int idDocente);

	Optional<Docente> findDocente(int idDocente);

	public void update(Docente docente);
}
