package pe.edu.upc.uhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.uhelp.entities.Promocion;

@Repository
public interface IPromocionRepository extends JpaRepository<Promocion, Integer>{

}
