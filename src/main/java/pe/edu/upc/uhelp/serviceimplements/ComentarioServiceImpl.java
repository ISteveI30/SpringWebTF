package pe.edu.upc.uhelp.serviceimplements;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Comentario;
import pe.edu.upc.uhelp.repositories.IComentarioRepository;
import pe.edu.upc.uhelp.serviceinterface.IComentarioService;

@Service
public class ComentarioServiceImpl implements IComentarioService{
@Autowired
private IComentarioRepository comentarioRepository;
	@Override
	public void insert(Comentario comentario) {
		// TODO Auto-generated method stub
		comentarioRepository.save(comentario);
	}

	@Override
	public List<Comentario> list() {
		// TODO Auto-generated method stub
		return comentarioRepository.findAll();
	}

	@Override
	public void delete(int idcomentario) {
		// TODO Auto-generated method stub
		comentarioRepository.deleteById(idcomentario);
	}

	@Override
	public Optional<Comentario> findComentario(int idcomentario) {
		// TODO Auto-generated method stub
		return comentarioRepository.findById(idcomentario);
	}

	@Override
	public void update(Comentario comentario) {
		// TODO Auto-generated method stub
		comentarioRepository.save(comentario);
	}
	
}
