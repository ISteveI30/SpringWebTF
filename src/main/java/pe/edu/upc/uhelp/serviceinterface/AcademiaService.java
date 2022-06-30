package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.Academia;
import pe.edu.upc.uhelp.util.RegistroAux;


public interface AcademiaService {
	public void insert(Academia academia);

	public List<Academia> list();
	
	public void delete(int idAcademia);

	public void update(Academia academia);
	
	Optional<Academia> findAcademia(int idAcademia);
	public RegistroAux usuarioSession(String username);
}
