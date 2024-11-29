package vn.edu.iuh.fit.wwwduongtuankietck;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.wwwduongtuankietck.backend.enums.Roles;
import vn.edu.iuh.fit.wwwduongtuankietck.backend.models.Candidate;
import vn.edu.iuh.fit.wwwduongtuankietck.backend.models.Experience;
import vn.edu.iuh.fit.wwwduongtuankietck.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.wwwduongtuankietck.backend.repositories.ExperienceRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class WwwDuongTuanKietCkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WwwDuongTuanKietCkApplication.class, args);
	}

	@Autowired
	CandidateRepository candidateRepository;

	@Autowired
	ExperienceRepository experienceRepository;

//	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			Faker faker = new Faker();


			for(int i = 1; i < 40; i++){
				// Candidate
				Candidate candidate = Candidate.builder()
						.phone(faker.phoneNumber().phoneNumber())
						.email(faker.internet().emailAddress())
						.fullName(faker.name().fullName())
						.build();
				candidateRepository.save(candidate);

				// khoi tạo nhiều Experience cho mỗi Candidate
				int numberOfExperiences = faker.number().numberBetween(1, 5); // Mỗi Candidate có từ 1-5 Experience
				for(int j = 0; j < numberOfExperiences; j++){
					LocalDate fromDate = faker.date()
							.past(3000, TimeUnit.DAYS)
							.toInstant()
							.atZone(ZoneId.systemDefault())
							.toLocalDate();
					LocalDate toDate = LocalDate.now()
							.minusDays(faker.number().numberBetween(1, 30));

					// Chọn một role ngẫu nhiên từ enum Roles
					Roles randomRole = Roles.values()[new Random().nextInt(Roles.values().length)];

					// Experience
					Experience experience = Experience.builder()
							.company(faker.company().name())
							.fromDate(fromDate)
							.toDate(toDate)
							.workDescription(faker.lorem().sentence())
							.role(randomRole)
							.candidate(candidate)
							.build();
					experienceRepository.save(experience);
				}


			}
		};
	}


}

