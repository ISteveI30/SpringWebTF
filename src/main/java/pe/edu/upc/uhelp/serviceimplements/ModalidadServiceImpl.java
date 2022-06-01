package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Modalidad;
import pe.edu.upc.uhelp.repositories.IModalidadRepository;
import pe.edu.upc.uhelp.serviceinterface.IModalidadService;

@Service
public class ModalidadServiceImpl implements IModalidadService {
	@Autowired
	private IModalidadRepository modalidadRepository;

	@Override
	public void insert(Modalidad modalidad) {
		modalidadRepository.save(modalidad);
	}

	@Override
	public List<Modalidad> list() {
		return modalidadRepository.findAll();
	}

	@Override
	public void delete(int idModalidad) {
		modalidadRepository.deleteById(idModalidad);
	}

	@Override
	public Optional<Modalidad> findModalidad(int idModalidad) {
		return modalidadRepository.findById(idModalidad);
	}

	@Override
	public void update(Modalidad modalidad) {
		modalidadRepository.save(modalidad);
		
	}

}
