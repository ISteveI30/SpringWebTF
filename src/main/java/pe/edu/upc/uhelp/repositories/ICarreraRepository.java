package pe.edu.upc.uhelp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.uhelp.entities.Carrera;

@Repository
public interface ICarreraRepository extends JpaRepository<Carrera, Integer>{

	@Query(value="Select c.nombre as Carrera, count(s.id_curso) as Cursos_registrados_por_Carrera from carreras c join cursos s on c.id_carrera=s.id_carrera group by c.nombre",nativeQuery=true)
	public List<String[]>QueryAlex();
	
}
