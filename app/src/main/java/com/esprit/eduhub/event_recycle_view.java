package com.esprit.eduhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.eduhub.database.AppDataBase;
import com.esprit.eduhub.entity.Evenement;

import java.util.List;

public class event_recycle_view extends AppCompatActivity {

    private RecyclerView eventList;
    private AppDataBase database;
    private List<Evenement> events;
    Button recycleaddevent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_recycle_view);

        database = AppDataBase.getAppDatabase(getApplicationContext());

        eventList = findViewById(R.id.eventList);

        events = database.evenementDao().getAll();
        System.out.println(events);
        EventAdapter adapter = new EventAdapter(events,this);
        eventList.setAdapter(adapter);
        eventList.setLayoutManager(new LinearLayoutManager(this));

        recycleaddevent=findViewById(R.id.recycleaddevent);
        recycleaddevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(event_recycle_view.this, Event.class);
                startActivity(intent);
            }
        });
    }

}
