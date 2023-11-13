package com.esprit.eduhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.esprit.eduhub.database.AppDataBase;
import com.esprit.eduhub.entity.Examen;

import java.util.List;

public class AddExamenActivity extends AppCompatActivity {

    Button save ;
    EditText name , niveau ;
    private AppDataBase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_examen);
        name =findViewById(R.id.namexamen);
        //niveau =findViewById(R.id.niveau);
        save =findViewById(R.id.saveexamen);
        //clear =findViewById(R.id.clearexamen);

        database = AppDataBase.getAppDatabase(getApplicationContext());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Examen examen = new Examen(name.getText().toString());
                database.examenDao().insertOne(examen);
                List<Examen> examenList = database.examenDao().getAll();
                System.out.println(examenList);
            }
        });
    }
}