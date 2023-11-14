package com.esprit.eduhub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.eduhub.entity.Utilisateur;

import java.util.ArrayList;

public class DashboardUtilisateurAdapter extends RecyclerView.Adapter<DashboardUtilisateurHolder> {

    ArrayList<Utilisateur> utilisateurs;

    public DashboardUtilisateurAdapter(ArrayList<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    @NonNull
    @Override
    public DashboardUtilisateurHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_utilisateur_item,parent,false);
        return new DashboardUtilisateurHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardUtilisateurHolder holder, int position) {
        holder.email.setText(utilisateurs.get(position).getEmail());
        holder.fullname.setText(utilisateurs.get(position).getPrenom() + utilisateurs.get(position).getNom());
        holder.fullname.setText("false");
    }

    @Override
    public int getItemCount() {
        return this.utilisateurs.size();
    }
}
