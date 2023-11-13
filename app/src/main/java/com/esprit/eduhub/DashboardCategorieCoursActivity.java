package com.esprit.eduhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.esprit.eduhub.database.AppDataBase;
import com.esprit.eduhub.entity.CategorieCours;

import java.util.ArrayList;
import java.util.List;

public class DashboardCategorieCoursActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, profile, cours;
    TextView toolbartitle;
    // --------
    private AppDataBase database;
    RecyclerView listCategorie;
    Button ajouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_categorie_cours);
        listCategorie = findViewById(R.id.dashboard_list_categories);
        ajouter = findViewById(R.id.dashboard_ajouter_btn);

        database = AppDataBase.getAppDatabase(getApplicationContext());
        List<CategorieCours> listCategorieCoursList = database.categorieCoursDao().getAll();
        ArrayList<CategorieCours> categories = new ArrayList<>();
        for (CategorieCours cat:listCategorieCoursList) {
            categories.add(cat);
        }
        DashboardCategorieCoursAdapter categorieAdapter = new DashboardCategorieCoursAdapter(categories);
        listCategorie.setAdapter(categorieAdapter);
        listCategorie.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(DashboardCategorieCoursActivity.this, AjoutCategorieCoursActivity.class);
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

        toolbartitle.setText("Cours");

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(DashboardCategorieCoursActivity.this, Index.class);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(DashboardCategorieCoursActivity.this, UserProfile.class);
            }
        });

        cours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(DashboardCategorieCoursActivity.this, CategorieActivity.class);
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