package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import pe.edu.upc.uhelp.entities.Carrera;

public interface ICarreraService {

	public void insert(Carrera person);

	public List<Carrera> list();
	
	public void delete(int idCarrera);

	public void update(Carrera person);
}
