package com.esprit.eduhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class Index extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, profile, cours, logout;
    TextView toolbartitle;
    Button savetest;
    private AppDataBase database;
    public SharedPreferences sp;
    String email = "", password= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        sp = getSharedPreferences(LoginFragment.spName, Context.MODE_PRIVATE);
        email = sp.getString("email", "default");
        password = sp.getString("password", "default");
        System.out.println(email + " : " + password);

        // ---------------------------------------------------------------
        // --------------------- Ajout fl base de donnees categorie
        // ---------------------------------------------------------------
        savetest = findViewById(R.id.savetest);
        database = AppDataBase.getAppDatabase(getApplicationContext());
        savetest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategorieCours categorieCours = new CategorieCours("abc");
                database.categorieCoursDao().insertOne(categorieCours);
                List<CategorieCours> categorieCoursList = database.categorieCoursDao().getAll();
                System.out.println(categorieCoursList);
            }
        });
        // ---------------------------------------------------------------
        // ---------------------------------------------------------------

        // ---------------------------------------------------------------
        // --------------------- Drawer Logic
        // ---------------------------------------------------------------
        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.nav_home_btn);
        profile = findViewById(R.id.nav_profile_btn);
        cours = findViewById(R.id.nav_cours_btn);
        logout = findViewById(R.id.nav_logout_btn);
        toolbartitle = findViewById(R.id.toolbar_title);

        toolbartitle.setText("Acceuil");

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(Index.this, UserProfile.class);
            }
        });

        cours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(Index.this, Cours.class);
            }
        });

        SharedPreferences.Editor preferencesEditor = sp.edit();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferencesEditor.clear();
                preferencesEditor.apply();
                redirectActivity(Index.this, MainActivity.class);
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