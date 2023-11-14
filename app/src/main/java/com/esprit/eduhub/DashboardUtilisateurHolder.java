package com.esprit.eduhub;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DashboardUtilisateurHolder extends RecyclerView.ViewHolder {

    TextView email, fullname, isBanned;
    ImageButton edit, delete;

    public DashboardUtilisateurHolder(@NonNull View itemView) {
        super(itemView);
        fullname = itemView.findViewById(R.id.utilisateur_fullname_item);
        isBanned = itemView.findViewById(R.id.utilisateur_isBanned_item);
        email = itemView.findViewById(R.id.utilisateur_email_item);
        edit = itemView.findViewById(R.id.dashboard_utilisateur_item_modifier_btn);
        delete = itemView.findViewById(R.id.dashboard_utilisateur_item_supprimer_btn);
    }
}
