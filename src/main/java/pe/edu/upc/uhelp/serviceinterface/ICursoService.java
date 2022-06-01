package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.Curso;

public interface ICursoService {

	public void insert(Curso curso);

	public List<Curso> list();

	public void delete(int idcurso);

	Optional<Curso> findCurso(int idcurso);

	public void update(Curso curso);
}
