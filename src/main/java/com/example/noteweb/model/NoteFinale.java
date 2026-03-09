package com.example.noteweb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notefinales")
public class NoteFinale {

    @Id
    private int id;

    @Column(name = "id_eleve")
    private int idEleve;

    @Column(name = "nom_eleve")
    private String nomEleve;

    @Column(name = "id_matiere")
    private int idMatiere;

    @Column(name = "nom_matiere")
    private String nomMatiere;

    @Column(name = "notefinale")
    private double noteFinale;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdEleve() { return idEleve; }
    public void setIdEleve(int idEleve) { this.idEleve = idEleve; }
    public String getNomEleve() { return nomEleve; }
    public void setNomEleve(String nomEleve) { this.nomEleve = nomEleve; }
    public int getIdMatiere() { return idMatiere; }
    public void setIdMatiere(int idMatiere) { this.idMatiere = idMatiere; }
    public String getNomMatiere() { return nomMatiere; }
    public void setNomMatiere(String nomMatiere) { this.nomMatiere = nomMatiere; }
    public double getNoteFinale() { return noteFinale; }
    public void setNoteFinale(double noteFinale) { this.noteFinale = noteFinale; }
}