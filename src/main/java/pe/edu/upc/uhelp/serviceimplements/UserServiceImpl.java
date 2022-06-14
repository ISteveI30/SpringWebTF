package pe.edu.upc.uhelp.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.uhelp.entities.Users;
import pe.edu.upc.uhelp.repositories.UserRepository;
import pe.edu.upc.uhelp.serviceinterface.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public void insert(Users users) {
		userRepository.save(users);
	}

	@Override
	public List<Users> list() {
	
		return userRepository.findAll();
	}

	@Override
	public void delete(int idUser) {
		userRepository.deleteById(idUser);
	}

	@Override
	public void update(Users users) {
		userRepository.save(users);
	}

	@Override
	public Optional<Users> findUsers(int idUser) {
		return userRepository.findById(idUser);
	}

}
