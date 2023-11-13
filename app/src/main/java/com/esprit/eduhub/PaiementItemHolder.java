package com.esprit.eduhub;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PaiementItemHolder extends RecyclerView.ViewHolder {

    TextView nom_carte, type_carte;
    ImageButton edit, delete;

    public PaiementItemHolder(@NonNull View itemView) {
        super(itemView);
        edit = itemView.findViewById(R.id.dashboard_paiement_item_modifier_btn);
        delete = itemView.findViewById(R.id.dashboard_paiement_item_supprimer_btn);
        nom_carte = itemView.findViewById(R.id.dashboard_paiement_nom_carte);
        type_carte = itemView.findViewById(R.id.dashboard_paiement_type_carte);
    }

}
