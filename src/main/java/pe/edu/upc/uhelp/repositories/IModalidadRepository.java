package pe.edu.upc.uhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.uhelp.entities.Modalidad;

@Repository
public interface IModalidadRepository extends JpaRepository<Modalidad, Integer>{

}
