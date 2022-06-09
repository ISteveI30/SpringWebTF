package pe.edu.upc.uhelp.serviceimplements;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.uhelp.entities.Rol;
import pe.edu.upc.uhelp.entities.Users;
import pe.edu.upc.uhelp.repositories.UserRepository;


@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.findByUsername(username);
		/*
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		*/
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Rol role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRol()));
		}

		return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
