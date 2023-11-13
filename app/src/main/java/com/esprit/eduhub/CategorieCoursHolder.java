package com.esprit.eduhub;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategorieCoursHolder extends RecyclerView.ViewHolder {

    TextView titre;
    ImageButton img;
    public CategorieCoursHolder(@NonNull View itemView) {
        super(itemView);
        titre = itemView.findViewById(R.id.categorie_item_titre);
        img = itemView.findViewById(R.id.categorie_item_img);
    }
}
