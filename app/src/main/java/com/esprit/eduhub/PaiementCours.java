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

public class PaiementCours extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, profile, cours, abonnement, forfait, paiement;
    TextView toolbartitle;

    RadioButton radioVisa, radioMasterCard, E_dinar;
    EditText editCardName, editCardNumber, editExpirationDate, editCvc;
    Button buttonPay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paiement_cours);

        radioVisa = findViewById(R.id.radioVisa);
        radioMasterCard = findViewById(R.id.radioMasterCard);
        E_dinar = findViewById(R.id.E_dinar);
        editCardName = findViewById(R.id.editCardName);
        editCardNumber = findViewById(R.id.editCardNumber);
        editExpirationDate = findViewById(R.id.editExpirationDate);
        editCvc = findViewById(R.id.editCvc);
        buttonPay = findViewById(R.id.buttonPay);

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupérez les valeurs des champs de saisie
                String cardName = editCardName.getText().toString();
                String cardNumber = editCardNumber.getText().toString();
                String expirationDate = editExpirationDate.getText().toString();
                String cvc = editCvc.getText().toString();

                if (TextUtils.isEmpty(cardName)) {
                    Toast.makeText(PaiementCours.this, "Veuillez saisir le nom de la carte", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(cardNumber) || cardNumber.length() < 16) {
                    Toast.makeText(PaiementCours.this, "Le numéro de carte doit avoir au moins 16 chiffres", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(expirationDate) || expirationDate.length() < 5) {
                    Toast.makeText(PaiementCours.this, "Veuillez saisir une date d'expiration au format MM/YY", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(cvc) || cvc.length() < 3) {
                    Toast.makeText(PaiementCours.this, "Le code CVC doit avoir au moins 3 chiffres", Toast.LENGTH_SHORT).show();
                } else if (!radioVisa.isChecked() && !radioMasterCard.isChecked() && !E_dinar.isChecked()) {
                    Toast.makeText(PaiementCours.this, "Veuillez sélectionner un type de carte", Toast.LENGTH_SHORT).show();
                } else {

                    showConfirmationDialog();
                }
            }
        });
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation de paiement")
                .setMessage("Votre paiement a été effectué avec succès !")
                .setPositiveButton("OK", null)
                .create()
                .show();
    }


    }

