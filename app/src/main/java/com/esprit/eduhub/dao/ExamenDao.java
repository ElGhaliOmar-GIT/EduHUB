package com.esprit.eduhub.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.esprit.eduhub.entity.Examen;

import java.util.List;

@Dao
public interface ExamenDao {
    @Insert
    void insertOne(Examen examen);
    @Delete
    void delete(Examen examen);
    @Query("SELECT * FROM examen")
    List<Examen> getAll();
}
