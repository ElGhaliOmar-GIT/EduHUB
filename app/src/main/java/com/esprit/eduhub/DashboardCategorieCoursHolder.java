package com.esprit.eduhub;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DashboardCategorieCoursHolder extends RecyclerView.ViewHolder {

    TextView titre;
    ImageButton edit, delete;

    public DashboardCategorieCoursHolder(@NonNull View itemView) {
        super(itemView);
        edit = itemView.findViewById(R.id.dashboard_categorie_item_modifier_btn);
        delete = itemView.findViewById(R.id.dashboard_categorie_item_supprimer_btn);
        titre = itemView.findViewById(R.id.dashboard_categorie_item_titre);
    }
}
