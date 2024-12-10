package vn.edu.iuh.fit.wwwduongtuankietck.backend.services.impl;

import vn.edu.iuh.fit.wwwduongtuankietck.backend.models.Candidate;
import vn.edu.iuh.fit.wwwduongtuankietck.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.wwwduongtuankietck.backend.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    private final CandidateRepository repository;

    public CandidateServiceImpl(CandidateRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Candidate> getAllCandidate() {
        return repository.findAll();
    }

    @Override
    public Candidate getCandidateById(long id) {
        Optional<Candidate> can = repository.findById(id);
        return can.orElse(null);
    }

    @Override
    public Collection<Candidate> getCandidateReport(String company) {
        return repository.findDeveloperCandidatesByCompany(company);
    }

    @Override
    public Collection<Candidate> findCandidateThan5Exp() {
        List<Candidate> candidates = repository.findAll();
        Collection<Candidate> result = new ArrayList<>();
        for (Candidate can : candidates) {
            can.getExperiences().forEach(experience -> {
                if (Period.between(experience.getFromDate(), experience.getToDate()).getYears() >= 5) {
                    result.add(can);
                }
            });
        }
        return result;
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        return repository.save(candidate);
    }

    @Override
    public boolean deleteCandidateById(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateCandidate(Candidate candidate) {
        if (repository.existsById(candidate.getId())) {
            repository.save(candidate);
            return true;
        }
        return false;
    }
}