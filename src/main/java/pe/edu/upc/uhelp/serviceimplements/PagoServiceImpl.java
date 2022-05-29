package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Pago;
import pe.edu.upc.uhelp.repositories.IPagoRepository;
import pe.edu.upc.uhelp.serviceinterface.IPagoService;

@Service
public class PagoServiceImpl implements IPagoService {

	/*Como los metodo crud ya provienen del japaRepository no es ncesario 
	 *declararlos en el Repository*/
	@Autowired
	private IPagoRepository pagoRepository;
	
	@Override
	public void insert(Pago person) {
		pagoRepository.save(person);
	}

	@Override
	public List<Pago> list() {
		return pagoRepository.findAll();
	}

	@Override
	public void delete(int idpago) {
		pagoRepository.deleteById(idpago);
	}

	@Override
	public Optional<Pago> findPago(int idpago) {
		return pagoRepository.findById(idpago);
	}

	@Override
	public void update(Pago pago) {
		pagoRepository.save(pago);
	}

}
