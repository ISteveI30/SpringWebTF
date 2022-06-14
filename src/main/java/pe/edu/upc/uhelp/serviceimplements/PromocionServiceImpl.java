package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Promocion;
import pe.edu.upc.uhelp.repositories.IPromocionRepository;
import pe.edu.upc.uhelp.serviceinterface.IPromocionService;

@Service
public class PromocionServiceImpl implements IPromocionService {

	private IPromocionRepository promocionRepository;

	@Override
	public void insert(Promocion promocion) {
		promocionRepository.save(promocion);
	}

	@Override
	public List<Promocion> list() {
		return promocionRepository.findAll();
	}

	@Override
	public void delete(int idPromocion) {
		promocionRepository.deleteById(idPromocion);
	}

	@Override
	public Optional<Promocion> findPromocion(int idPromocion) {
		return promocionRepository.findById(idPromocion);
	}

	@Override
	public void update(Promocion promocion) {
		promocionRepository.save(promocion);
	}

}
