package com.esprit.eduhub.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.esprit.eduhub.entity.CategorieCours;

import java.util.List;

@Dao
public interface CategorieCoursDao {
    @Insert
    void insertOne(CategorieCours categorieCours);
    @Delete
    void delete(CategorieCours categorieCours);
    @Query("SELECT * FROM categorie_cours")
    List<CategorieCours> getAll();
}
