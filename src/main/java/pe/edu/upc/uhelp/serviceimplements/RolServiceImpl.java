package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Rol;
import pe.edu.upc.uhelp.repositories.IRolRepository;
import pe.edu.upc.uhelp.serviceinterface.RolService;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private IRolRepository rolRepository;
	
	@Override
	public void insert(Rol rol) {
		rolRepository.save(rol);
	}

	@Override
	public List<Rol> list() {
		return rolRepository.findAll();
	}

	@Override
	public void delete(int idRol) {
		rolRepository.deleteById(idRol);
	}

	@Override
	public void update(Rol rol) {
		rolRepository.save(rol);
	}

	@Override
	public Optional<Rol> findRol(int idRol) {
		return rolRepository.findById(idRol);
	}

}
