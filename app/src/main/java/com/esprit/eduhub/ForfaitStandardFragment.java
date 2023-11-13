package com.esprit.eduhub;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class ForfaitStandardFragment extends Fragment {




    RadioButton radioPremium, radioStandard;
    Button confirm_button;



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment

            View view = inflater.inflate(R.layout.fragment_forfait_standard, container, false);

            radioPremium = view.findViewById(R.id.fragmentPremium);
           confirm_button = view.findViewById(R.id.confirm_button);

            // Mise à jour de la logique pour le clic sur le bouton "Confirmer"
            confirm_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Redirigez vers l'activité de paiement des cours ici
                    // Utilisez une intention (Intent) ou une autre méthode de navigation
                    // Exemple avec Intent :
                    Intent intent = new Intent(getActivity(), PaiementCours.class);
                    startActivity(intent);
                }
            });

            // Mise à jour de la logique pour le clic sur le bouton radio "Premium"
            radioPremium.setOnClickListener(e -> {
                // Mettez à jour les informations ou effectuez d'autres actions
                // relatives au choix du forfait standard ici
            });

            return view;
        }
    }
