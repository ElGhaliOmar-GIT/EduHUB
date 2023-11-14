package com.esprit.eduhub.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.esprit.eduhub.entity.Utilisateur;

import java.util.List;

@Dao
public interface UtilisateurDao {
    @Insert
    void insertOne(Utilisateur utilisateur);
    @Delete
    void delete(Utilisateur utilisateur);
    @Query("SELECT * FROM utilisateur")
    List<Utilisateur> getAll();
}
