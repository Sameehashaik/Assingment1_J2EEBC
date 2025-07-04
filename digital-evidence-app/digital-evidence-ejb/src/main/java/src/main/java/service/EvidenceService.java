package src.main.java.service;

import src.main.java.model.Evidence;
import src.main.java.repository.EvidenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EvidenceService {

    @Autowired
    private EvidenceRepository evidenceRepository;

    public Evidence save(Evidence evidence) {
        return evidenceRepository.save(evidence);
    }

    public List<Evidence> findAll() {
        return evidenceRepository.findAll();
    }

    public Optional<Evidence> findById(Long id) {
        return evidenceRepository.findById(id);
    }

    public List<Evidence> findByCustodyStatus(String status) {
        return evidenceRepository.findByCustodyStatus(status);
    }

    public List<Evidence> findBySourceOfficer(String officer) {
        return evidenceRepository.findBySourceOfficer(officer);
    }

    public List<Evidence> findByEncrypted(boolean encrypted) {
        return evidenceRepository.findByEncrypted(encrypted);
    }

    public List<Evidence> findByDateOfAcquisition(LocalDate date) {
        return evidenceRepository.findByDateOfAcquisition(date);
    }
}
