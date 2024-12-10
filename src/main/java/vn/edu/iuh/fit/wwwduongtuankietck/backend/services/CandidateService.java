package vn.edu.iuh.fit.wwwduongtuankietck.backend.services;

import vn.edu.iuh.fit.wwwduongtuankietck.backend.models.Candidate;

import java.util.Collection;


public interface CandidateService {
    Collection<Candidate> getAllCandidate();
    Candidate getCandidateById(long id);
    Collection<Candidate> getCandidateReport(String company);
    Collection<Candidate>  findCandidateThan5Exp();
    Candidate saveCandidate(Candidate candidate);
    boolean deleteCandidateById(Long id);
    boolean updateCandidate(Candidate candidate);
}
