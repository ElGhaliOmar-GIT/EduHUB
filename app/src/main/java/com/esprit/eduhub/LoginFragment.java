package com.esprit.eduhub;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginFragment extends Fragment {

    TextView signUpBtn;
    EditText emailInput, passwordInput;
    Button loginBtn;
    public SharedPreferences sp;
    public static String spName = "sharedPref";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        signUpBtn = view.findViewById(R.id.login_signup_btn);
        loginBtn = view.findViewById(R.id.login_connect_btn);
        emailInput = view.findViewById(R.id.login_email_input);
        passwordInput = view.findViewById(R.id.login_passwor_input);

        sp = getActivity().getSharedPreferences(spName, Context.MODE_PRIVATE);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("email", emailInput.getText().toString());
                editor.putString("password", passwordInput.getText().toString());
                editor.apply();

                Intent intent = new Intent(getActivity(), Index.class);
                startActivity(intent);
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_login_signup, new SignupFragment()).commit();
            }
        });

        return view;
    }
}