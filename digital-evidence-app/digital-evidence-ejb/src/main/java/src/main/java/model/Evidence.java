package src.main.java.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "evidence")
public class Evidence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String evidenceId;  

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String sourceOfficer;

    @Column(nullable = false)
    private LocalDate dateOfAcquisition;

    @Column(nullable = false)
    private String custodyStatus;

    @Column(nullable = false)
    private String lastCustodian;

    @Column(nullable = false)
    private boolean encrypted;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEvidenceId() { return evidenceId; }
    public void setEvidenceId(String evidenceId) { this.evidenceId = evidenceId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSourceOfficer() { return sourceOfficer; }
    public void setSourceOfficer(String sourceOfficer) { this.sourceOfficer = sourceOfficer; }

    public LocalDate getDateOfAcquisition() { return dateOfAcquisition; }
    public void setDateOfAcquisition(LocalDate dateOfAcquisition) { this.dateOfAcquisition = dateOfAcquisition; }

    public String getCustodyStatus() { return custodyStatus; }
    public void setCustodyStatus(String custodyStatus) { this.custodyStatus = custodyStatus; }

    public String getLastCustodian() { return lastCustodian; }
    public void setLastCustodian(String lastCustodian) { this.lastCustodian = lastCustodian; }

    public boolean isEncrypted() { return encrypted; }
    public void setEncrypted(boolean encrypted) { this.encrypted = encrypted; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
