package com.esprit.eduhub.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class Question {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "label")
    private String label;
    /*@ColumnInfo(name = "reponses")
    private String[] reponses;*/

    // ----------------------------------
    // ----------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}