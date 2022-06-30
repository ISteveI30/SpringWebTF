package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Orden;
import pe.edu.upc.uhelp.repositories.IOrdenRepository;
import pe.edu.upc.uhelp.serviceinterface.IOrdenService;

@Service
public class IOrdenServiceImpl implements IOrdenService {

	@Autowired
	private IOrdenRepository ordenRepository;
	
	@Override
	public void insert(Orden orden) {
		ordenRepository.save(orden);
	}

	@Override
	public List<Orden> list() {
		return ordenRepository.findAll();
	}

	@Override
	public void delete(int idorden) {
		ordenRepository.deleteById(idorden);
	}

	@Override
	public Optional<Orden> findOrden(int idorden) {
		return ordenRepository.findById(idorden);
	}

	@Override
	public void update(Orden orden) {
		ordenRepository.save(orden);
	}

	@Override
	public List<String[]> QueryJhon() {
		return ordenRepository.QueryJhon();
	}

	@Override
	public List<String[]> QueryMontototal() {
		return ordenRepository.QueryMontototal();
	}

}
