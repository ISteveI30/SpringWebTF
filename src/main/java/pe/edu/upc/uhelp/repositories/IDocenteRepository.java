package pe.edu.upc.uhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.uhelp.entities.Docente;
//Repositorio de la entidad docentes
@Repository
public interface IDocenteRepository extends JpaRepository<Docente, Integer>{

}
