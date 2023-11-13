package com.esprit.eduhub;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.eduhub.database.AppDataBase;
import com.esprit.eduhub.entity.CategorieCours;

import java.util.ArrayList;

public class DashboardCategorieCoursAdapter extends RecyclerView.Adapter<DashboardCategorieCoursHolder> {

    ArrayList<CategorieCours> categories;
    private AppDataBase database;

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
    public void onBindViewHolder(@NonNull DashboardCategorieCoursHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.titre.setText(categories.get(position).getTitre());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDataBase.getAppDatabase(v.getContext()).categorieCoursDao().delete(categories.get(position));
                categories.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.categories.size();
    }
}
