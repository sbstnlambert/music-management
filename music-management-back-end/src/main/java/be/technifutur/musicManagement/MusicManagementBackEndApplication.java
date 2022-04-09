package be.technifutur.musicManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MusicManagementBackEndApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MusicManagementBackEndApplication.class, args);
	}

}
