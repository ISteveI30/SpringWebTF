package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Carrera;
import pe.edu.upc.uhelp.repositories.ICarreraRepository;
import pe.edu.upc.uhelp.serviceinterface.ICarreraService;

@Service
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

	@Override
	public Optional<Carrera> findCarrera(int idcarrera) {
		return carreraRepository.findById(idcarrera);
	}

	@Override
	public List<String[]> QueryAlex() {
		return carreraRepository.QueryAlex();
	}

}
