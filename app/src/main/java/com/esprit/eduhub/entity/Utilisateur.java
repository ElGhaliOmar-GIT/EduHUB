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
    @ColumnInfo(name = "image")
    private String image;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "mdp")
    private String mdp;
    @ColumnInfo(name = "role")
    private String role;
    @ColumnInfo(name = "bio_un")
    private String bioUn;
    @ColumnInfo(name = "bio_deux")
    private String bioDeux;
    @ColumnInfo(name = "is_banned")
    private Boolean isBanned;

    // ----------------------------------
    // ----------------------------------

    public Utilisateur(String prenom, String nom, String image, String email, String mdp, String role, String bioUn, String bioDeux, Boolean isBanned) {
        this.prenom = prenom;
        this.nom = nom;
        this.image = image;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
        this.bioUn = bioUn;
        this.bioDeux = bioDeux;
        this.isBanned = isBanned;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", image='" + image + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                ", role='" + role + '\'' +
                ", bioUn='" + bioUn + '\'' +
                ", bioDeux='" + bioDeux + '\'' +
                ", isBanned=" + isBanned +
                '}';
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getBioUn() {
        return bioUn;
    }

    public void setBioUn(String bioUn) {
        this.bioUn = bioUn;
    }

    public String getBioDeux() {
        return bioDeux;
    }

    public void setBioDeux(String bioDeux) {
        this.bioDeux = bioDeux;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }
}
