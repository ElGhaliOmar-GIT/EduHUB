package com.esprit.eduhub;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExamenItemHolder extends RecyclerView.ViewHolder {

    TextView examenTitre;
    TextView niveauDiff;
    ImageButton edit, delete;

    public ExamenItemHolder(@NonNull View itemView) {
        super(itemView);
        edit = itemView.findViewById(R.id.dashboard_examen_item_modifier_btn);
        delete = itemView.findViewById(R.id.dashboard_examen_item_supprimer_btn);
        examenTitre=itemView.findViewById(R.id.dashboard_examen_item_name);
        niveauDiff=itemView.findViewById(R.id.dashboard_examen_item_niveau);

    }
}
