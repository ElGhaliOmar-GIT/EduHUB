package com.esprit.eduhub.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.Date;
import java.util.List;

@Entity
public class Evenement {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "titre")
    private String titre;
    @ColumnInfo(name = "lieu")
    private String lieu;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "status")
    private String status;
    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "img")
    private int img;



    // ----------------------------------
    @ColumnInfo(name = "utilisateur_id") // Foreign key reference
    private int utilisateurId;
    // ----------------------------------

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Evenement(String titre, String lieu, String date, String description, String status, String type, int img) {
        this.titre = titre;
        this.lieu = lieu;
        this.date = date;
        this.description = description;
        this.status = status;
        this.type = type;
        this.img = img;
    }
    @Override
    public String toString() {
        return "Evenement{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", lieu='" + lieu + '\'' +
                ", date='" + lieu + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", img='" + img + '\'' +
                ", utilisateurId=" + utilisateurId +
                '}';
    }
}
