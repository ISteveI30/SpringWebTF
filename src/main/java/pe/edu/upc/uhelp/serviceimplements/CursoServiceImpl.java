package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Curso;
import pe.edu.upc.uhelp.repositories.ICursoRespository;
import pe.edu.upc.uhelp.serviceinterface.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService{

	@Autowired
	private ICursoRespository cursoRepository;
	
	@Override
	public void insert(Curso curso) {
		cursoRepository.save(curso);
	}

	@Override
	public List<Curso> list() {
		return cursoRepository.findAll();
	}

	@Override
	public void delete(int idcurso) {
		cursoRepository.deleteById(idcurso);
	}

	@Override
	public Optional<Curso> findCurso(int idcurso) {
		return cursoRepository.findById(idcurso);
	}

	@Override
	public void update(Curso curso) {
		cursoRepository.save(curso);
	}

}
