package pe.edu.upc.uhelp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.uhelp.entities.Docente;

@Repository
public interface IDocenteRepository extends JpaRepository<Docente, Integer>{

	@Query(value="Select c.nombre as Docente, count(s.id_curso) as Cantidad_Cursos_por_Docente from docentes c join cursos s on c.id_docente=s.id_docente group by c.nombre",nativeQuery=true)
	public List<String[]>QueryLuis();
}
