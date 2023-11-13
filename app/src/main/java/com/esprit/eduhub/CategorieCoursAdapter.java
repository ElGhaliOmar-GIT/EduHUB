package com.esprit.eduhub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.eduhub.entity.CategorieCours;

import java.util.ArrayList;

public class CategorieCoursAdapter extends RecyclerView.Adapter<CategorieCoursHolder> {
    ArrayList<CategorieCours> categories;

    public CategorieCoursAdapter(ArrayList<CategorieCours> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategorieCoursHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.categorie_cours_item,parent,false);
        return new CategorieCoursHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategorieCoursHolder holder, int position) {
        holder.titre.setText(categories.get(position).getTitre());
    }

    @Override
    public int getItemCount() {
        return this.categories.size();
    }
}
