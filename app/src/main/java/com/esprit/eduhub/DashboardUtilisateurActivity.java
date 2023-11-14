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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.esprit.eduhub.database.AppDataBase;
import com.esprit.eduhub.entity.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class DashboardUtilisateurActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, profile, cours;
    TextView toolbartitle;
    // ----
    private AppDataBase database;
    RecyclerView utilisateurListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_utilisateur);
        utilisateurListView = findViewById(R.id.dashboard_list_utilisateur);

        database = AppDataBase.getAppDatabase(getApplicationContext());
        List<Utilisateur> utilisateursList = database.utilisateurDao().getAll();
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        for (Utilisateur ut:utilisateursList) {
            utilisateurs.add(ut);
        }
        System.out.println(utilisateurs.toString());
        DashboardUtilisateurAdapter utilisateurAdapter = new DashboardUtilisateurAdapter(utilisateurs);
        utilisateurListView.setAdapter(utilisateurAdapter);
        utilisateurListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));

        // ---------------------------------------------------------------
        // --------------------- Drawer Logic
        // ---------------------------------------------------------------
        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.nav_home_btn);
        profile = findViewById(R.id.nav_profile_btn);
        cours = findViewById(R.id.nav_cours_btn);
        toolbartitle = findViewById(R.id.toolbar_title);

        toolbartitle.setText("Dashboard - Utilisateur");

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(DashboardUtilisateurActivity.this, Index.class);
            }
        });

        cours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(DashboardUtilisateurActivity.this, Cours.class);
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