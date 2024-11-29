package vn.edu.iuh.fit.wwwduongtuankietck.backend.repositories;

import vn.edu.iuh.fit.wwwduongtuankietck.backend.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
