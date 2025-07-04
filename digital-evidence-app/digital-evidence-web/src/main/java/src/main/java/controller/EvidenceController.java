package src.main.java.controller;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import src.main.java.model.Evidence;
import src.main.java.service.EvidenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/digital-evidence")
public class EvidenceController {

    @Autowired
    private EvidenceService evidenceService;

    @GetMapping("/add-form")
    public String showForm(Model model) {
        model.addAttribute("evidence", new Evidence());
        return "evidenceForm";
    }

    @PostMapping("/save")
    public String saveEvidence(@Valid @ModelAttribute Evidence evidence,
                               BindingResult result,
                               Model model) {

        if (result.hasErrors()) {
            return "evidenceForm";
        }

        if (evidence.getEvidenceId() == null || evidence.getEvidenceId().isEmpty()) {
            String generatedId = UUID.randomUUID().toString();
            evidence.setEvidenceId(generatedId);
        }

        evidenceService.save(evidence);
        model.addAttribute("success", "Evidence registered successfully!");

        return "redirect:/digital-evidence/view-all";
    }

    @GetMapping("/view-all")
    public String viewAll(Model model) {
        List<Evidence> evidenceList = evidenceService.findAll();
        model.addAttribute("evidenceList", evidenceList);
        return "allEvidence";
    }

    @GetMapping("/view-all-incustody")
    public String viewInCustody(Model model) {
        List<Evidence> inCustody = evidenceService.findByCustodyStatus("In Custody");
        model.addAttribute("evidenceList", inCustody);
        return "inCustodyEvidence";
    }
}
