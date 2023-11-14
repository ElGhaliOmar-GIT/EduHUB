package com.esprit.eduhub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.esprit.eduhub.database.AppDataBase;
import com.esprit.eduhub.entity.Utilisateur;

import java.util.List;

public class SignupFragment extends Fragment {

    TextView logInBtn;
    Button saveBtn;
    EditText fnameInput, lnameInput, emailInput, passworInput;
    private AppDataBase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        logInBtn = view.findViewById(R.id.signup_login_btn);
        saveBtn = view.findViewById(R.id.signup_save_btn);
        fnameInput = view.findViewById(R.id.signup_fname_input);
        lnameInput = view.findViewById(R.id.signup_lname_input);
        emailInput = view.findViewById(R.id.signup_email_input);
        passworInput = view.findViewById(R.id.signup_passwor_input);

        database = AppDataBase.getAppDatabase(getActivity().getApplicationContext());
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilisateur utilisateur = new Utilisateur(fnameInput.getText().toString(), lnameInput.getText().toString(), "",
                        emailInput.getText().toString(), passworInput.getText().toString(),
                        "etudiant", "", "", false);
                database.utilisateurDao().insertOne(utilisateur);
                // ---- testing
                List<Utilisateur> utilisateurList = database.utilisateurDao().getAll();
                System.out.println(utilisateurList.toString());
                // ----
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_login_signup, new LoginFragment()).commit();
            }
        });

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_login_signup, new LoginFragment()).commit();
            }
        });

        return view;
    }
}