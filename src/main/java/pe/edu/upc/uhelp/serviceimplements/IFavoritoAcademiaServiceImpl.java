package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.FavoritoAcademia;
import pe.edu.upc.uhelp.repositories.IFavoritoAcademiaRepository;
import pe.edu.upc.uhelp.serviceinterface.IFavoritoAcademiaService;

@Service
public class IFavoritoAcademiaServiceImpl implements IFavoritoAcademiaService {

	@Autowired
	private IFavoritoAcademiaRepository favoritoRepository;

	@Override
	public void insert(FavoritoAcademia academia) {
		favoritoRepository.save(academia);
	}

	@Override
	public List<FavoritoAcademia> list() {
		return favoritoRepository.findAll();
	}

	@Override
	public void delete(int idacademia) {
		favoritoRepository.deleteById(idacademia);
	}

	@Override
	public Optional<FavoritoAcademia> findOrden(int idacademia) {
		return favoritoRepository.findById(idacademia);
	}

	@Override
	public void update(FavoritoAcademia academia) {
		favoritoRepository.save(academia);
	}
}
