package pe.edu.upc.uhelp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class TfUHelpApplication/* implements CommandLineRunner */{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	public static void main(String[] args) {
		SpringApplication.run(TfUHelpApplication.class, args);
		/*var password="123";
		System.out.println("password: "+password);
		System.out.println("password: "+encriptarPassword(password));*/
	}
	/*
	public static String encriptarPassword(String password) {
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String bcryptPassword = passwordEncoder.encode(password);
		return bcryptPassword;
	}
	*//*
	@Override
	public void run(String... args) throws Exception {

		String password = "web";

		for (int i = 0; i < 1; i++) {
			String bcryptPassword = passwordEncoder.encode(password);
			System.out.println(bcryptPassword);
		}
	}*/
}
