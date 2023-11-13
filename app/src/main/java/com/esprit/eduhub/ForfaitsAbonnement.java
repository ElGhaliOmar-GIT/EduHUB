package com.esprit.eduhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ForfaitsAbonnement extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, profile, cours, abonnement, forfait;
    TextView toolbartitle;

    Button confirm_button ;
    RadioButton radioStandard, radioPremium ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forfaits_abonnement);

        confirm_button = findViewById(R.id.confirm_button);
        radioStandard = findViewById(R.id.fragmentStandard);
        radioPremium = findViewById(R.id.fragmentPremium);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        radioStandard.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                fragmentTransaction.replace(R.id.forfaitStandardContainer, new ForfaitStandardFragment());
                fragmentTransaction.commit();
            }
        });

        radioPremium.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                fragmentTransaction.replace(R.id.forfaitPremiumContainer, new ForfaitPremiumFragment());
                fragmentTransaction.commit();
            }
        });
        // ...

        confirm_button.setOnClickListener( View-> {

            Intent intent = new Intent(this, PaiementCours.class);
            startActivity(intent);




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
        abonnement = findViewById(R.id.nav_AbonnementCours);
        forfait = findViewById(R.id.nav_AbonnementCours);
        toolbartitle = findViewById(R.id.toolbar_title);

        toolbartitle.setText("Acceuil");

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        abonnement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(ForfaitsAbonnement.this, UserProfile.class);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(ForfaitsAbonnement.this, Index.class);
            }
        });
        forfait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(ForfaitsAbonnement.this, Index.class);
            }
        });


        // ---------------------------------------------------------------
        // ---------------------------------------------------------------
    }
        // ---------------------------------------------------------------
        // ---------------------------------------------------------------




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