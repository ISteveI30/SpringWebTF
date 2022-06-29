package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Estudiante;
import pe.edu.upc.uhelp.entities.Users;
import pe.edu.upc.uhelp.repositories.IEstudianteRespository;
import pe.edu.upc.uhelp.repositories.UserRepository;
import pe.edu.upc.uhelp.serviceinterface.EstudianteService;
import pe.edu.upc.uhelp.util.RegistroAux;

@Service
public class EstudianteServiceImpl  implements EstudianteService{
	
	@Autowired
	private IEstudianteRespository estudianteRepository;
	
	@Autowired
	private UserRepository userRepository;
	
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
	public Optional<Estudiante> findEstudiante(int idEstudiante) {
		return estudianteRepository.findById(idEstudiante);
	}

	@Override
	public RegistroAux usuarioSession(String username) {

		var aux= new RegistroAux();
		var student= new Estudiante();
		Users user = userRepository.findByUsername(username);
		Optional<Estudiante> obj = estudianteRepository.findById(user.getEstudiante().getIdEstudiante());
		student=obj.get();
		aux.setStudent(student);
		aux.setNombre(student.getNombre());
		aux.setApellido(student.getApellido());
		aux.setCorreo(student.getCorreo());
		//aux.setPassword(user.getPassword());
		return aux;
	}

}
