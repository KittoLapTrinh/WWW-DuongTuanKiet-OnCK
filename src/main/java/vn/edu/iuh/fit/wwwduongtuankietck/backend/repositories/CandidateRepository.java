package vn.edu.iuh.fit.wwwduongtuankietck.backend.repositories;

import vn.edu.iuh.fit.wwwduongtuankietck.backend.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    @Query("Select c from Candidate c where c.id IN (select e.candidate.id from Experience e where e.workDescription = 'Developer' AND e.company like CONCAT ('%', :company, '%'))")
    Collection<Candidate> findDeveloperCandidatesByCompany(@Param("company") String company);
}
