package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.Rol;

public interface RolService {
	public void insert(Rol rol);

	public List<Rol> list();
	
	public void delete(int idRol);

	public void update(Rol rol);
	
	Optional<Rol> findRol(int idRol);
}
