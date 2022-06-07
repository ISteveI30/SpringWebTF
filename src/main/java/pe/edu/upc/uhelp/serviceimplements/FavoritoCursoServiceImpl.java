package pe.edu.upc.uhelp.serviceimplements;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.FavoritoCurso;
import pe.edu.upc.uhelp.repositories.IFavoritoCursoRepository;
import pe.edu.upc.uhelp.serviceinterface.IFavoritoCursoService;

@Service
public class FavoritoCursoServiceImpl implements IFavoritoCursoService{
	@Autowired
	private IFavoritoCursoRepository favoritoCursoRepository;
	
	
	@Override
	public void insert(FavoritoCurso favoritoCurso) {
		// TODO Auto-generated method stub
		favoritoCursoRepository.save(favoritoCurso);
	}

	@Override
	public List<FavoritoCurso> list() {
		// TODO Auto-generated method stub
		return favoritoCursoRepository.findAll();
	}

	@Override
	public void delete(int idfavoritoCurso) {
		// TODO Auto-generated method stub
		favoritoCursoRepository.deleteById(idfavoritoCurso);
	}

	@Override
	public Optional<FavoritoCurso> findCurso(int idfavoritoCurso) {
		// TODO Auto-generated method stub
		return favoritoCursoRepository.findById(idfavoritoCurso);
	}

	@Override
	public void update(FavoritoCurso favoritoCurso) {
		// TODO Auto-generated method stub
		favoritoCursoRepository.save(favoritoCurso);
	}

}
