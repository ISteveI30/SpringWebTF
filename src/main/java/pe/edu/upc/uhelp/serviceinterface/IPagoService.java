package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;
import pe.edu.upc.uhelp.entities.Pago;


public interface IPagoService {

	public void insert(Pago person);

	public List<Pago> list();

	public void delete(int idpago);

	Optional<Pago> findPago(int idpago);

	public void update(Pago person);
}
