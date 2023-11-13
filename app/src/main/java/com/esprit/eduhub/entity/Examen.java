package com.esprit.eduhub.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

@Entity
public class Examen {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nom")
    private String nom;
    @ColumnInfo(name = "niveauDiff")
    private String niveauDiff;


    // ----------------------------------

    public void setNiveauDiff(String niveauDiff) {
        this.niveauDiff = niveauDiff;
    }

    public String getNiveauDiff() {
        return niveauDiff;
    }
    // ----------------------------------

    public int getId() {
        return id;
    }

    public Examen(String nom, String niveauDiff) {
        this.nom = nom;
        this.niveauDiff = niveauDiff;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
