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

import com.esprit.eduhub.entity.Examen;

import java.util.ArrayList;

public class ExamenActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, profile, cours , examenButtom;
    TextView toolbartitle;
    RecyclerView examenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);

        examenList = findViewById(R.id.listexamen);
        ArrayList<Examen> exams = new ArrayList<>() ;
        exams.add(new Examen("Titre"));
        exams.add(new Examen("Titre2"));
        exams.add(new Examen("Titre3"));

        ExamenItemAdapter examenItemAdapter = new ExamenItemAdapter(exams);
        examenList.setAdapter(examenItemAdapter);
        examenList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));

        // ---------------------------------------------------------------
        // --------------------- Drawer Logic
        // ---------------------------------------------------------------
        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.nav_home_btn);
        profile = findViewById(R.id.nav_profile_btn);
        cours = findViewById(R.id.nav_cours_btn);
        toolbartitle = findViewById(R.id.toolbar_title);
        examenButtom = findViewById(R.id.nav_examen_btn);

        toolbartitle.setText("Examen");

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        examenButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(ExamenActivity.this, Index.class);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(ExamenActivity.this, UserProfile.class);
            }
        });

        cours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(ExamenActivity.this, Cours.class);
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