package pe.edu.upc.uhelp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.uhelp.entities.Orden;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer>{

	@Query(value="Select ordenes.id_orden, detalle_ordenes.nombre, ordenes.fecha_compra, ordenes.total from ordenes Inner Join detalle_ordenes ON ordenes.id_orden = detalle_ordenes.orden_id_orden;",nativeQuery=true)
	public List<String[]>QueryJhon();
	
	@Query(value="select p.nombre,p.cantidad,p.precio, sum(p.cantidad*p.precio) as Total_de_Compra from detalle_ordenes p join ordenes d on p.orden_id_orden=d.id_orden group by p.nombre,p.cantidad,p.precio",nativeQuery=true)
	public List<String[]>QueryMontototal();
}
