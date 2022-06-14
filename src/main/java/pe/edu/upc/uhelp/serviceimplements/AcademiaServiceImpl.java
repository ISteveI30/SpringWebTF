package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Academia;
import pe.edu.upc.uhelp.repositories.IAcademiaRepository;
import pe.edu.upc.uhelp.serviceinterface.AcademiaService;

@Service
public class AcademiaServiceImpl implements AcademiaService{

	@Autowired
	private IAcademiaRepository academiaRepository;
	
	@Override
	public void insert(Academia academia) {
		academiaRepository.save(academia);
	}

	@Override
	public List<Academia> list() {
		return academiaRepository.findAll();
	}

	@Override
	public void delete(int idAcademia) {
		academiaRepository.deleteById(idAcademia);
	}

	@Override
	public void update(Academia academia) {
		academiaRepository.save(academia);
	}

	@Override
	public Optional<Academia> findAcademia(int idAcademia) {
		return academiaRepository.findById(idAcademia);
	}

}
