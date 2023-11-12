package com.esprit.eduhub.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;

@Entity
public class Utilisateur {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "prenom")
    private String prenom;
    @ColumnInfo(name = "nom")
    private String nom;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "mdp")
    private String mdp;
    @ColumnInfo(name = "role")
    private String role;

    // ----------------------------------
    // ----------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
