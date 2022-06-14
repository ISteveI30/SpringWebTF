package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.Academia;


public interface AcademiaService {
	public void insert(Academia academia);

	public List<Academia> list();
	
	public void delete(int idAcademia);

	public void update(Academia academia);
	
	Optional<Academia> findAcademia(int idAcademia);
}
