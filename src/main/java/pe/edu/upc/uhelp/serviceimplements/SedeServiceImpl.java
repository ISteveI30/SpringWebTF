package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Sede;
import pe.edu.upc.uhelp.repositories.ISedeRepository;
import pe.edu.upc.uhelp.serviceinterface.ISedeService;

@Service
public class SedeServiceImpl implements ISedeService{

	@Autowired
	private ISedeRepository sedeRepository;
	@Override
	public void insert(Sede sede) {
		sedeRepository.save(sede);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Sede> list() {
		// TODO Auto-generated method stub
		return sedeRepository.findAll();
	}

	@Override
	public void delete(int idPerson) {
		// TODO Auto-generated method stub
		sedeRepository.deleteById(idPerson);
	}

	@Override
	public Optional<Sede> listId(int idSede) {
		// TODO Auto-generated method stub
		return sedeRepository.findById(idSede);
	}

	@Override
	public void update(Sede sede) {
		// TODO Auto-generated method stub
		sedeRepository.save(sede);
	}

}
