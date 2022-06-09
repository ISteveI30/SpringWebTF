package pe.edu.upc.uhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.uhelp.entities.Estudiante;

@Repository
public interface IEstudianteRespository extends JpaRepository<Estudiante, Integer> {

}
