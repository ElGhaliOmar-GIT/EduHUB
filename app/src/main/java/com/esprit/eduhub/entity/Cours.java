package com.esprit.eduhub.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Cours {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nom_cours")
    private String nomCours;
    @ColumnInfo(name = "description")
    private String description;

    // ----------------------------------


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
