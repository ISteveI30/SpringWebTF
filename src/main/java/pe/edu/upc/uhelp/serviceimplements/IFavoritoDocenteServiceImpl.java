package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.FavoritoDocente;
import pe.edu.upc.uhelp.repositories.IFavoritoDocenteRepository;
import pe.edu.upc.uhelp.serviceinterface.IFavoritoDocenteService;

@Service
public class IFavoritoDocenteServiceImpl implements IFavoritoDocenteService {

	@Autowired
	private IFavoritoDocenteRepository favoritoRepository;
	
	@Override
	public void insert(FavoritoDocente fdoc) {
		favoritoRepository.save(fdoc);
	}

	@Override
	public List<FavoritoDocente> list() {
		return favoritoRepository.findAll();
	}

	@Override
	public void delete(int idfdoc) {
		favoritoRepository.deleteById(idfdoc);
	}

	@Override
	public Optional<FavoritoDocente> findOrden(int idfdoc) {
		return favoritoRepository.findById(idfdoc);
	}

	@Override
	public void update(FavoritoDocente fdoc) {
		favoritoRepository.save(fdoc);
	}

}
