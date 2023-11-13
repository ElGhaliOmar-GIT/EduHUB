package com.esprit.eduhub;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExamenItemHolder extends RecyclerView.ViewHolder {

    TextView examenTitre;
    TextView niveauDiff;

    public ExamenItemHolder(@NonNull View itemView) {
        super(itemView);
        examenTitre=itemView.findViewById(R.id.item_examen_titre);
        niveauDiff=itemView.findViewById(R.id.item_examen_niveau);

    }
}
