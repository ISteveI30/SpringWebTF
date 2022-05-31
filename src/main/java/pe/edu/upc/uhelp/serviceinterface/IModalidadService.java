package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.Modalidad;

public interface IModalidadService {

	public void insert(Modalidad modalidad);
	
	public List<Modalidad> list();
	
	public void delete (int idModalidad);
	
	Optional<Modalidad> findModalidad(int idModalidad);
	
	public void update(Modalidad modalidad);
}
