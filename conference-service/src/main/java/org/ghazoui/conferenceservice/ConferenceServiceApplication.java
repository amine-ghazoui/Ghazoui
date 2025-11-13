package org.ghazoui.conferenceservice;

import org.ghazoui.conferenceservice.entities.Conference;
import org.ghazoui.conferenceservice.entities.Review;
import org.ghazoui.conferenceservice.entities.TypeConference;
import org.ghazoui.conferenceservice.feign.KeynoteRestClient;
import org.ghazoui.conferenceservice.model.Keynote;
import org.ghazoui.conferenceservice.repositories.ConferenceRepository;
import org.ghazoui.conferenceservice.repositories.ReviewRepository;
import org.ghazoui.conferenceservice.services.ConferenceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ConferenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceServiceApplication.class, args);
	}


	//@Bean
	CommandLineRunner commandLineRunner(ConferenceRepository conferenceRepository, ConferenceService conferenceService) {
		return args -> {

			Conference conf1 = conferenceRepository.save(Conference.builder()
					.titre("Intelligence Artificielle et Machine Learning")
					.typeConference(TypeConference.ACADEMIQUE)
					.date(new Date())
					.duree(180) // 3 heures
					.nombreInscrits(150)
					.score(0.0)
					.build());
			conferenceRepository.save(conf1);

			Conference conf2 = conferenceRepository.save(Conference.builder()
					.titre("Sécurité des Systèmes d'Information")
					.typeConference(TypeConference.ACADEMIQUE)
					.date(new Date())
					.duree(240) // 4 heures
					.nombreInscrits(200)
					.score(0.0)
					.build());
			conferenceRepository.save(conf2);

			Conference conf3 = conferenceRepository.save(Conference.builder()
					.titre("Cloud Computing : AWS vs Azure vs GCP")
					.typeConference(TypeConference.COMMERCIALE)
					.date(new Date())
					.duree(120) // 2 heures
					.nombreInscrits(120)
					.score(0.0)
					.build());
			conferenceRepository.save(conf3);

			Conference conf4 = conferenceRepository.save(Conference.builder()
					.titre("Big Data Analytics et Business Intelligence")
					.typeConference(TypeConference.COMMERCIALE)
					.date(new Date())
					.duree(150)
					.nombreInscrits(180)
					.score(0.0)
					.build());
			conferenceRepository.save(conf4);

			Conference conf5 = conferenceRepository.save(Conference.builder()
					.titre("Architecture Microservices avec Spring Cloud")
					.typeConference(TypeConference.ACADEMIQUE)
					.date(new Date())
					.duree(240)
					.nombreInscrits(160)
					.score(0.0)
					.build());
			conferenceRepository.save(conf5);
		};
	}

	// ✅ Réactivé : L'accès GET aux keynotes est maintenant permis pour les appels inter-services
	// Le keynote-service permet l'accès GET sans authentification (pour Feign)
	// Le gateway continue à protéger les endpoints pour le frontend
	@Bean
	CommandLineRunner commandLineRunner2(ConferenceRepository conferenceRepository,
										 ReviewRepository reviewRepository,
										 KeynoteRestClient keynoteRestClient) {
		return args -> {

			Collection<Keynote> keynotes = keynoteRestClient.getAllKeynotes();

			keynotes.forEach(keynote -> {
				Conference conf = Conference.builder()
						.titre("Conférence de " + keynote.getPrenom() + " " + keynote.getNom())
						.typeConference(Math.random() > 0.5 ? TypeConference.ACADEMIQUE : TypeConference.COMMERCIALE)
						.date(new Date())
						.duree(120 + (int) (Math.random() * 90))
						.nombreInscrits(100 + (int) (Math.random() * 200))
						.score(0.0)
						.keynoteId(keynote.getId())
						.build();
				Conference savedConf = conferenceRepository.save(conf);

				reviewRepository.save(Review.builder()
						.date(new Date())
						.text("Présentation captivante de " + keynote.getPrenom())
						.note(5)
						.conference(savedConf)
						.build());

				reviewRepository.save(Review.builder()
						.date(new Date())
						.text("Très bon contenu, bien structuré.")
						.note(4)
						.conference(savedConf)
						.build());

				reviewRepository.save(Review.builder()
						.date(new Date())
						.text("Quelques points à approfondir, mais globalement intéressant.")
						.note(3)
						.conference(savedConf)
						.build());



			});

		};
	}

}



// Un Keynote peut présenter PLUSIEURS conférences (1 K --> * C)
// Une Conférence peut avoir PLUSIEURS reviews (évaluations) (1 C --> * R )
