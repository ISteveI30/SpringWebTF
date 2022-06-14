package pe.edu.upc.uhelp.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.uhelp.entities.Users;

public interface UserService {
	public void insert(Users users);

	public List<Users> list();
	
	public void delete(int idUser);

	public void update(Users users);
	
	Optional<Users> findUsers(int idUser);
}
