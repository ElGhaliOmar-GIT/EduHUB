package com.esprit.eduhub.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.esprit.eduhub.PaiementCours;
import com.esprit.eduhub.entity.Paiement;

import java.util.List;

@Dao
public interface PaiementDao {
    @Insert
    void insertOne(Paiement paiement);
    @Delete
    void delete(Paiement paiement);
    @Query("SELECT * FROM paiement")
    List<Paiement> getAll();
}
