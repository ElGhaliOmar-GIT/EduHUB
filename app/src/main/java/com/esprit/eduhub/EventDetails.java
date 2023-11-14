package com.esprit.eduhub;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.esprit.eduhub.database.AppDataBase;
import com.esprit.eduhub.entity.Evenement;

public class EventDetails extends AppCompatActivity {

    NotificationManagerCompat notificationManagerCompat;
    Notification notification;

    ImageView img;
    Button deretour, eventdelete, participe;
    TextView titreList, lieuList, detaildate, detaildescription, detailstatus, detailtype;
    private AppDataBase database;
    private int eventId;
    private String eventTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("myCh", "My Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);

        img = findViewById(R.id.Detailimg);
        titreList = findViewById(R.id.detailtitre);
        lieuList = findViewById(R.id.detailieu);
        detaildate = findViewById(R.id.detaildate);
        detaildescription = findViewById(R.id.detaildescription);
        detailstatus = findViewById(R.id.detailstatus);
        detailtype = findViewById(R.id.detailtype);
        deretour = findViewById(R.id.deretour);
        participe = findViewById(R.id.participe);
        eventdelete = findViewById(R.id.eventdelete);

        // Get the event ID from the Intent
        eventTitle = getIntent().getStringExtra("titreList");
        eventId = getIntent().getIntExtra("id", -1);
        titreList.setText(getIntent().getStringExtra("titreList"));
        lieuList.setText(getIntent().getStringExtra("lieuList"));
        detaildate.setText(getIntent().getStringExtra("detaildate"));
        detaildescription.setText(getIntent().getStringExtra("detaildescription"));
        detailstatus.setText(getIntent().getStringExtra("detailstatus"));
        detailtype.setText(getIntent().getStringExtra("detailtype"));
        img.setImageResource(getIntent().getIntExtra("img", 1));


        String notificationMessage = "Thank you for your participation in the event " + eventTitle + ". We are thrilled to have you join us for this exciting event.";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "myCh")
                .setSmallIcon(android.R.drawable.stat_notify_sync)
                .setContentTitle("Notification")
                .setContentText(notificationMessage);

        notification = builder.build();
        notificationManagerCompat = NotificationManagerCompat.from(this);
        deretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventDetails.this, event_recycle_view.class);
                startActivity(intent);
            }
        });

        eventdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Delete the event from the database
                deleteEvent();

                // Navigate back to the event_recycle_view activity
                Intent intent = new Intent(EventDetails.this, event_recycle_view.class);
                startActivity(intent);
            }
        });
    }

    public void push(View view) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            return;
        }
        notificationManagerCompat.notify(1, notification);

    }

    private void deleteEvent() {
        // Initialize the database
        database = AppDataBase.getAppDatabase(getApplicationContext());
    System.out.println("ye bhim");
        // Use the event ID to delete the event from the database
    System.out.println("dadad"+eventId);
            Evenement eventToDelete = database.evenementDao().getEventById(eventId);
            System.out.println("menji weld ftayma "+eventToDelete);
            if (eventToDelete != null) {
                database.evenementDao().delete(eventToDelete);
            }

    }




    }
