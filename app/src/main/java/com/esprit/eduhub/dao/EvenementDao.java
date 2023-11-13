package com.esprit.eduhub.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.esprit.eduhub.entity.Evenement;

import java.util.List;


@Dao
public interface EvenementDao {

    @Insert
    long insert(Evenement evenement);

    @Update
    void update(Evenement evenement);

    @Delete
    void delete(Evenement evenement);

    @Query("SELECT * FROM Evenement")
    List<Evenement> getAll();
    @Query("SELECT * FROM Evenement WHERE id = :eventId")
    Evenement getEventById(int eventId);
}
