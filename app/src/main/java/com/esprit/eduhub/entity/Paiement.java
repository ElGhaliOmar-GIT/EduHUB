package com.esprit.eduhub.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Paiement {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "type_carte")
    private String typeCarte;
    @ColumnInfo(name = "nom_carte")
    private String nomCarte;
    @ColumnInfo(name = "numero_carte")
    private int numeroCarte;
    @ColumnInfo(name = "code_carte")
    private int codeCarte;

    // ----------------------------------
    // ----------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeCarte() {
        return typeCarte;
    }

    public void setTypeCarte(String typeCarte) {
        this.typeCarte = typeCarte;
    }

    public String getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(String nomCarte) {
        this.nomCarte = nomCarte;
    }

    public int getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(int numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public int getCodeCarte() {
        return codeCarte;
    }

    public void setCodeCarte(int codeCarte) {
        this.codeCarte = codeCarte;
    }
}
