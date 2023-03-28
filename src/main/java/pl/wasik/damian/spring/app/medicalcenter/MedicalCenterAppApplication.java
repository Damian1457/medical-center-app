package pl.wasik.damian.spring.app.medicalcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicalCenterAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalCenterAppApplication.class, args);
	}

}

// TODO: 21.03.2023 Dla modelu Pacjent stworzyć warstwy web, service i repository, oraz test jednostkowy dla repozitory.
