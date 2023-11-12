package com.esprit.eduhub.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Commentaire {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "contenu")
    private String contenu;

    @ColumnInfo(name = "utilisateur_id") // Foreign key reference
    private int utilisateurId;
    @ColumnInfo(name = "evennement_id") // Foreign key reference
    private int evennementId;

    // ----------------------------------
    // ----------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public int getEvennementId() {
        return evennementId;
    }

    public void setEvennementId(int evennementId) {
        this.evennementId = evennementId;
    }
}
