package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.upc.uhelp.entities.Carrera;
import pe.edu.upc.uhelp.repositories.ICarreraRepository;
import pe.edu.upc.uhelp.serviceinterface.ICarreraService;

public class CarreraServiceImpl implements ICarreraService {

	
	@Autowired
	private ICarreraRepository carreraRepository;
	
	@Override
	public void insert(Carrera c) {
		carreraRepository.save(c);
	}

	@Override
	public List<Carrera> list() {
		return carreraRepository.findAll();
	}

	@Override
	public void delete(int idcarrera) {
		carreraRepository.deleteById(idcarrera);
	}

	@Override
	public void update(Carrera carrera) {
		carreraRepository.save(carrera);
	}

	
	
}
