package com.esprit.eduhub;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;


public class ForfaitPremiumFragment extends Fragment {
        RadioButton radioPremium;
        Button confirm_button;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.fragment_forfait_standard, container, false);

            radioPremium = view.findViewById(R.id.fragmentPremium);
            confirm_button = view.findViewById(R.id.confirm_button);
            confirm_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), PaiementCours.class);
                    startActivity(intent);
                }
            });
            radioPremium.setOnClickListener(e -> {
            });

            return view;
        }



    }


