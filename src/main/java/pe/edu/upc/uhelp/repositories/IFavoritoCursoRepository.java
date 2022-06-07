package pe.edu.upc.uhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.uhelp.entities.FavoritoCurso;

@Repository
public interface IFavoritoCursoRepository extends JpaRepository<FavoritoCurso, Integer> {

}
