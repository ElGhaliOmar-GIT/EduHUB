package com.esprit.eduhub.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

@Entity(tableName = "examen")
public class Examen {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nom")
    private String nom;
//    @ColumnInfo(name = "niveauDiff")
//    private String niveauDiff;


    // ----------------------------------

//    public void setNiveauDiff(String niveauDiff) {
//        this.niveauDiff = niveauDiff;
//    }
//
//    public String getNiveauDiff() {
//        return niveauDiff;
//    }
    // ----------------------------------

    public int getId() {
        return id;
    }

    public Examen(String nom) {
        this.nom = nom;
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

    @Override
    public String toString() {
        return "Examen{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
