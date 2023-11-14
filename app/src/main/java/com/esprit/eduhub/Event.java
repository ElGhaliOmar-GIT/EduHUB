package com.esprit.eduhub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.esprit.eduhub.database.AppDataBase;
import com.esprit.eduhub.entity.Evenement;

import java.util.List;

public class Event extends AppCompatActivity {


    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, profile, cours , evenement;
    TextView toolbartitle;
    Button addevent , Retour;
    EditText titre, lieu, description, status, type, date;
    private AppDataBase database ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenement);

        // -------------------------------Ajout fl base de donnees evenement--------------------------------
        // ---------------------------------------------------------------

        titre = findViewById(R.id.titre);
        lieu = findViewById(R.id.lieu);
        description = findViewById(R.id.description);
        status = findViewById(R.id.status);
        type = findViewById(R.id.type);
        date = findViewById(R.id.date);
        addevent = findViewById(R.id.addevent);
        Retour = findViewById(R.id.Retour);
        database = AppDataBase.getAppDatabase(getApplicationContext());
        addevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Evenement evenem = new Evenement(titre.getText().toString(), lieu.getText().toString(),date.getText().toString(), description.getText().toString(), status.getText().toString(), type.getText().toString(), R.drawable.logo_circle_blue);

                // Insert the event into the database
                long insertedRowId = database.evenementDao().insert(evenem);

                if (insertedRowId != -1) {
                    // Insertion was successful
                    System.out.println("Event inserted successfully. Row ID: " + insertedRowId);

                    // Retrieve and print all events in the database
                    List<Evenement> ev = database.evenementDao().getAll();
                    System.out.println("All events in the database:");
                    for (Evenement evenList : ev) {
                        System.out.println(evenList);
                    }
                    // Start the EventRecyclerViewActivity
                    Intent intent = new Intent(Event.this, event_recycle_view.class);
                    startActivity(intent);
                } else {
                    // Insertion failed
                    System.out.println("Failed to insert event into the database.");
                }

            }



        });

        Retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Event.this, event_recycle_view.class);
                startActivity(intent);
            }
        });


        // ---------------------------------------------------------------
        // --------------------- Drawer Logic
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
        toolbartitle = findViewById(R.id.toolbar_title);
        evenement= findViewById(R.id.nav_evenement_btn);

        toolbartitle.setText("Evenements");

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(Event.this, Index.class);
            }
        });

        evenement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(Event.this, UserProfile.class);
            }
        });

        cours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(Event.this, Cours.class);
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
}