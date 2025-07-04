package src.main.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import src.main.java.model.Evidence;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Long> {
	
    List<Evidence> findByCustodyStatus(String custodyStatus);
    
  List<Evidence> findBySourceOfficer(String sourceOfficer);
  
  List<Evidence> findByDateOfAcquisition(LocalDate dateOfAcquisition);
    List<Evidence> findByEncrypted(boolean encrypted);

}
