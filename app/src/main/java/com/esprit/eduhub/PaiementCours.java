package com.esprit.eduhub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.esprit.eduhub.database.AppDataBase;
import com.esprit.eduhub.entity.Paiement;

import java.util.List;

public class PaiementCours extends AppCompatActivity {
    Button save;
    EditText nomCarte, numeroCarte, dateExpiration, codeCarte;
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, profile, cours, abonnement, forfait,paiementcours, paiement;
    TextView toolbartitle;
    Button buttonPay;
    RadioButton radioVisa, radioMasterCard, E_dinar;
    private AppDataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paiement_cours);

        nomCarte = findViewById(R.id.editCardName);
        numeroCarte = findViewById(R.id.editCardNumber);
        dateExpiration = findViewById(R.id.editExpirationDate);
        codeCarte = findViewById(R.id.editCvc);
        radioVisa = findViewById(R.id.radioVisa);
        radioMasterCard = findViewById(R.id.radioMasterCard);
        E_dinar = findViewById(R.id.E_dinar);
        buttonPay = findViewById(R.id.buttonPay);


        database = AppDataBase.getAppDatabase(getApplicationContext());

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cartType = "";

                if (radioVisa.isChecked()) {
                    cartType = "Visa";
                }
                if (radioMasterCard.isChecked()) {
                    cartType = "MasterCard";
                }
                if (E_dinar.isChecked()) {
                    cartType = "edinar";
                }

                Paiement paiement = new Paiement(cartType, nomCarte.getText().toString(), Integer.parseInt(numeroCarte.getText().toString()), dateExpiration.getText().toString(), Integer.parseInt(codeCarte.getText().toString()));
                database.paiementDao().insertOne(paiement);
                List<Paiement> paiementList = database.paiementDao().getAll();
                System.out.println(paiementList);


                showConfirmationDialog();
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
        abonnement = findViewById(R.id.nav_AbonnementCours);
        forfait = findViewById(R.id.nav_AbonnementCours);
        paiementcours = findViewById(R.id.nav_Paiement_Cours);
        paiement = findViewById(R.id.nav_Paiement_Cours);
        toolbartitle = findViewById(R.id.toolbar_title);

        toolbartitle.setText("Acceuil");

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        paiementcours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(PaiementCours.this, UserProfile.class);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(PaiementCours.this, Index.class);
            }
        });
        forfait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(PaiementCours.this, Index.class);
            }
        });
        abonnement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(PaiementCours.this, Index.class);
            }
        });
        paiement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(PaiementCours.this, Index.class);
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

        private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation de paiement")
                .setMessage("Votre paiement a été effectué avec succès !")
                .setPositiveButton("OK", null)
                .create()
                .show();
        }

}










