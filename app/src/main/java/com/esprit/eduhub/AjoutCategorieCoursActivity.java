package com.esprit.eduhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.esprit.eduhub.database.AppDataBase;
import com.esprit.eduhub.entity.CategorieCours;

import java.util.List;

public class AjoutCategorieCoursActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, profile, cours;
    TextView toolbartitle;
    // --------
    private AppDataBase database;
    EditText titre;
    Button ajoutBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_categorie_cours);
        ajoutBtn = findViewById(R.id.ajout_categ_btn);
        titre = findViewById(R.id.ajout_categ_titre);

        database = AppDataBase.getAppDatabase(getApplicationContext());
        ajoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategorieCours categorieCours = new CategorieCours(titre.getText().toString());
                database.categorieCoursDao().insertOne(categorieCours);
                List<CategorieCours> categorieCoursList = database.categorieCoursDao().getAll();

                redirectActivity(AjoutCategorieCoursActivity.this, DashboardCategorieCoursActivity.class);
            }
        });

        // ---------------------------------------------------------------
        // --------------------- Drawer Logic
        // ---------------------------------------------------------------
        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.nav_home_btn);
        profile = findViewById(R.id.nav_profile_btn);
        cours = findViewById(R.id.nav_cours_btn);
        toolbartitle = findViewById(R.id.toolbar_title);

        toolbartitle.setText("Ajout Categorie");

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(AjoutCategorieCoursActivity.this, UserProfile.class);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(AjoutCategorieCoursActivity.this, Index.class);
            }
        });

        cours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(AjoutCategorieCoursActivity.this, CategorieActivity.class);
            }
        });
        // ---------------------------------------------------------------
        // ---------------------------------------------------------------

    }

    // ---------------------------------------------------------------
    // --------------------- Drawer Methodes
    // ---------------------------------------------------------------
    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity, Class secondActivity) {
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
    // ---------------------------------------------------------------
    // ---------------------------------------------------------------

}