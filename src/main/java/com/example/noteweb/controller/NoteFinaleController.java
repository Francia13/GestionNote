package com.example.noteweb.controller;

import com.example.noteweb.model.NoteFinale;
import com.example.noteweb.repository.NoteFinaleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NoteFinaleController {

    private final NoteFinaleRepository repository;

    public NoteFinaleController(NoteFinaleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(
            @RequestParam(required = false, defaultValue = "") String eleve,
            @RequestParam(required = false, defaultValue = "") String matiere,
            Model model) {

        List<NoteFinale> notes = repository.findByNomEleveContainingIgnoreCaseAndNomMatiereContainingIgnoreCase(eleve, matiere);
        model.addAttribute("notes", notes);
        return "index";
    }

    @GetMapping("/filterById")
    public String filterById(
            @RequestParam(required = false) Integer idEleve,
            @RequestParam(required = false) Integer idMatiere,
            Model model) {

        List<NoteFinale> notes;

        if (idEleve != null && idMatiere != null) {
            notes = repository.findAll().stream()
                    .filter(n -> n.getIdEleve() == idEleve && n.getIdMatiere() == idMatiere)
                    .toList();
        } else if (idEleve != null) {
            notes = repository.findAll().stream()
                    .filter(n -> n.getIdEleve() == idEleve)
                    .toList();
        } else if (idMatiere != null) {
            notes = repository.findAll().stream()
                    .filter(n -> n.getIdMatiere() == idMatiere)
                    .toList();
        } else {
            notes = repository.findAll();
        }

        model.addAttribute("notes", notes);
        return "index";
    }
}