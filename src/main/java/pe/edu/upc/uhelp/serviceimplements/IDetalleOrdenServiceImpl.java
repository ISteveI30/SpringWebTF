package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.DetalleOrden;
import pe.edu.upc.uhelp.repositories.IDetalleOrdenRepository;
import pe.edu.upc.uhelp.serviceinterface.IDetalleOrdenService;

@Service
public class IDetalleOrdenServiceImpl implements IDetalleOrdenService {

	@Autowired
	private IDetalleOrdenRepository detalleRepository;
	
	@Override
	public void insert(DetalleOrden dorden) {
		detalleRepository.save(dorden);
	}

	@Override
	public List<DetalleOrden> list() {
		return detalleRepository.findAll();
	}

	@Override
	public void delete(int idorden) {
		detalleRepository.deleteById(idorden);
	}

	@Override
	public Optional<DetalleOrden> findOrden(int idorden) {
		return detalleRepository.findById(idorden);
	}

	@Override
	public void update(DetalleOrden dorden) {
		detalleRepository.save(dorden);
	}

}
