/*package pe.edu.upc.uhelp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import pe.edu.upc.uhelp.TfUHelpApplication;
/*
@SpringBootApplication
public class EncriptarPassword implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EncriptarPassword.class, args);
		
	}
	
	public static String encriptarPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	@Override
	public void run(String... args) throws Exception {

		var password="123";
		System.out.println("password: "+password);
		System.out.println("password: "+encriptarPassword(password));
	}
}*/
