package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.Sede;

public interface ISedeService {

	public void insert (Sede sede);
	
	public List <Sede> list();
	
	public void delete (int idPerson);
	
	Optional<Sede> listId(int idSede);
	
	public void update(Sede sede);
}
