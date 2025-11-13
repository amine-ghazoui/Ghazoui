package org.ghazoui.keynoteservice;

import org.ghazoui.keynoteservice.dtos.KeynoteDTO;
import org.ghazoui.keynoteservice.entities.Keynote;
import org.ghazoui.keynoteservice.repositories.KeynoteRepository;
import org.ghazoui.keynoteservice.services.KeynoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeynoteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeynoteServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KeynoteService keynoteService, KeynoteRepository keynoteRepository) {
		return args -> {
			System.out.println("========== Initialisation des Keynotes ==========");

			Keynote keynote1 = keynoteRepository.save(Keynote.builder()
					.nom("Bennis")
					.prenom("Mohammed")
					.email("m.bennis@conference.ma")
					.fonction("Professeur en Intelligence Artificielle")
					.build());
			keynoteRepository.save(keynote1);

			Keynote keynote2 = keynoteRepository.save(Keynote.builder()
					.nom("El Alami")
					.prenom("Fatima")
					.email("f.elalami@conference.ma")
					.fonction("Directrice de Recherche en Cybersécurité")
					.build());
			keynoteRepository.save(keynote2);

			Keynote keynote3 = keynoteRepository.save(Keynote.builder()
					.nom("Tazi")
					.prenom("Ahmed")
					.email("a.tazi@conference.ma")
					.fonction("Expert en Cloud Computing")
					.build());
			keynoteRepository.save(keynote3);

			Keynote keynote4 = keynoteRepository.save(Keynote.builder()
					.nom("Lahlou")
					.prenom("Samira")
					.email("s.lahlou@conference.ma")
					.fonction("Spécialiste en Big Data et Analytics")
					.build());
			keynoteRepository.save(keynote4);

			Keynote keynote5 = keynoteRepository.save(Keynote.builder()
					.nom("Benjelloun")
					.prenom("Youssef")
					.email("y.benjelloun@conference.ma")
					.fonction("Architecte Solutions Microservices")
					.build());
			keynoteRepository.save(keynote5);

			Keynote keynote6 = keynoteRepository.save(Keynote.builder()
					.nom("Alaoui")
					.prenom("Meriem")
					.email("m.alaoui@conference.ma")
					.fonction("Chef de Projet DevOps")
					.build());
			keynoteRepository.save(keynote6);

			Keynote keynote7 = keynoteRepository.save(Keynote.builder()
					.nom("Hafidi")
					.prenom("Karim")
					.email("k.hafidi@conference.ma")
					.fonction("Consultant en Transformation Digitale")
					.build());
			keynoteRepository.save(keynote7);
		};
	}
}
