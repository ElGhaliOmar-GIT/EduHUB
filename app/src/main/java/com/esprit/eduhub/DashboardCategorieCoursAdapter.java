package com.esprit.eduhub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.eduhub.entity.CategorieCours;

import java.util.ArrayList;

public class DashboardCategorieCoursAdapter extends RecyclerView.Adapter<DashboardCategorieCoursHolder> {

    ArrayList<CategorieCours> categories;

    public DashboardCategorieCoursAdapter(ArrayList<CategorieCours> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public DashboardCategorieCoursHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_categorie_cours_item,parent,false);
        return new DashboardCategorieCoursHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardCategorieCoursHolder holder, int position) {
        holder.titre.setText(categories.get(position).getTitre());
    }

    @Override
    public int getItemCount() {
        return this.categories.size();
    }
}
