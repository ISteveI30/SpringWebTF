package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Estudiante;
import pe.edu.upc.uhelp.repositories.IEstudianteRespository;
import pe.edu.upc.uhelp.serviceinterface.EstudianteService;

@Service
public class EstudianteServiceImpl  implements EstudianteService{
	
	@Autowired
	private IEstudianteRespository estudianteRepository;
	
	@Override
	public void insert(Estudiante estudiante) {
		estudianteRepository.save(estudiante);
	}

	@Override
	public List<Estudiante> list() {
		return estudianteRepository.findAll();
	}

	@Override
	public void delete(int idEstudiante) {
		estudianteRepository.deleteById(idEstudiante);
	}

	@Override
	public void update(Estudiante estudiante) {
		estudianteRepository.save(estudiante);
	}

	@Override
	public Optional<Estudiante> findCarrera(int idEstudiante) {
		return estudianteRepository.findById(idEstudiante);
	}

}
