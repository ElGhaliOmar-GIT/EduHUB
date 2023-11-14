package com.esprit.eduhub;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DashboardUtilisateurHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView email, fullname, isBanned;

    public DashboardUtilisateurHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.utilisateur_img_item);
        fullname = itemView.findViewById(R.id.utilisateur_fullname_item);
        isBanned = itemView.findViewById(R.id.utilisateur_isBanned_item);
        email = itemView.findViewById(R.id.utilisateur_email_item);
    }
}
