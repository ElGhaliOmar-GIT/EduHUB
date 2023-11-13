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
import com.esprit.eduhub.entity.Examen;

import java.util.List;

public class AddExamenActivity extends AppCompatActivity {

    Button save ;
    EditText name , niveau ;
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, profile, cours , examenButtom;
    TextView toolbartitle;
    Button savetest;
    private AppDataBase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_examen);
        name =findViewById(R.id.namexamen);
        niveau =findViewById(R.id.niveau);
        save =findViewById(R.id.saveexamen);
        //clear =findViewById(R.id.clearexamen);

        database = AppDataBase.getAppDatabase(getApplicationContext());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(AddExamenActivity.this, ExamenActivity.class);
                Examen examen = new Examen(name.getText().toString(),niveau.getText().toString());
                database.examenDao().insertOne(examen);
                List<Examen> examenList = database.examenDao().getAll();
                System.out.println(examenList);


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
        examenButtom = findViewById(R.id.nav_examen_btn);

        toolbartitle.setText("Acceuil");

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(AddExamenActivity.this, UserProfile.class);
            }
        });

        cours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(AddExamenActivity.this, Cours.class);
            }
        });
        examenButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(AddExamenActivity.this, ExamenActivity.class);
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