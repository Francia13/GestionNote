package com.example.noteweb.repository;

import com.example.noteweb.model.NoteFinale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteFinaleRepository extends JpaRepository<NoteFinale, Integer> {

    List<NoteFinale> findByNomEleveContainingIgnoreCase(String nomEleve);

    List<NoteFinale> findByNomMatiereContainingIgnoreCase(String nomMatiere);

    List<NoteFinale> findByNomEleveContainingIgnoreCaseAndNomMatiereContainingIgnoreCase(String nomEleve, String nomMatiere);
}