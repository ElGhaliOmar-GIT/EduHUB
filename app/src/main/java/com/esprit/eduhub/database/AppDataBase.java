package com.esprit.eduhub.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.esprit.eduhub.dao.AbonnementDao;
import com.esprit.eduhub.dao.CategorieCoursDao;
import com.esprit.eduhub.dao.CommentaireDao;
import com.esprit.eduhub.dao.CoursDao;
import com.esprit.eduhub.dao.EvenementDao;
import com.esprit.eduhub.dao.ExamenDao;
import com.esprit.eduhub.dao.PaiementDao;
import com.esprit.eduhub.dao.QuestionDao;
import com.esprit.eduhub.dao.UtilisateurDao;
import com.esprit.eduhub.entity.Abonnement;
import com.esprit.eduhub.entity.CategorieCours;
import com.esprit.eduhub.entity.Commentaire;
import com.esprit.eduhub.entity.Cours;
import com.esprit.eduhub.entity.Evenement;
import com.esprit.eduhub.entity.Examen;
import com.esprit.eduhub.entity.Paiement;
import com.esprit.eduhub.entity.Question;
import com.esprit.eduhub.entity.Utilisateur;

@Database(entities = {Utilisateur.class, Commentaire.class, CategorieCours.class, Abonnement.class,
Cours.class, Evenement.class, Examen.class, Paiement.class, Question.class,}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance;
    public abstract UtilisateurDao utilisateurDao();
    public abstract QuestionDao questionDao();
    public abstract PaiementDao paiementDao();
    public abstract ExamenDao examenDao();
    public abstract EvenementDao evenementDao();
    public abstract CoursDao coursDao();
    public abstract CommentaireDao commentaireDao();
    public abstract CategorieCoursDao categorieCoursDao();
    public abstract AbonnementDao abonnementDao();

    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "eduhub_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
