package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Academia;
import pe.edu.upc.uhelp.entities.Users;
import pe.edu.upc.uhelp.repositories.IAcademiaRepository;
import pe.edu.upc.uhelp.repositories.UserRepository;
import pe.edu.upc.uhelp.serviceinterface.AcademiaService;
import pe.edu.upc.uhelp.util.RegistroAux;

@Service
public class AcademiaServiceImpl implements AcademiaService{

	@Autowired
	private IAcademiaRepository academiaRepository;
	
	@Autowired
	private UserRepository userRepository;
	
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

	@Override
	public RegistroAux usuarioSession(String username) {
		var aux= new RegistroAux();
		var academia= new Academia();
		Users user = userRepository.findByUsername(username);
		Optional<Academia> obj = academiaRepository.findById(user.getAcademia().getIdAcademia());
		academia=obj.get();
		aux.setNombre(academia.getNombre());
		aux.setTelefono(academia.getTelefono());
		aux.setCorreo(academia.getCorreo());
		aux.setSedes(academia.getSede().getNombre());
		//aux.setPassword(user.getPassword());
		return aux;
	}

}
