package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.Estudiante;


public interface EstudianteService {
	public void insert(Estudiante estudiante);

	public List<Estudiante> list();
	
	public void delete(int idEstudiante);

	public void update(Estudiante estudiante);
	
	Optional<Estudiante> findEstudiante(int idEstudiante);
}
