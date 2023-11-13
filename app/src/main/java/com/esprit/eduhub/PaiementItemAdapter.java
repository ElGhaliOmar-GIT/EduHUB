package com.esprit.eduhub;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.eduhub.database.AppDataBase;
import com.esprit.eduhub.entity.Paiement;

import java.util.ArrayList;

public class PaiementItemAdapter extends RecyclerView.Adapter<PaiementItemHolder> {
    ArrayList<Paiement> paiements;

    public PaiementItemAdapter(ArrayList<Paiement> paiements) {
        this.paiements = paiements;
    }

    @NonNull
    @Override
    public PaiementItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.paiement_item,parent,false);
        return new PaiementItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PaiementItemHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.nom_carte.setText(paiements.get(position).getNomCarte());
        holder.type_carte.setText(paiements.get(position).getTypeCarte());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDataBase.getAppDatabase(v.getContext()).paiementDao().delete(paiements.get(position));
                paiements.remove(position);
                notifyItemRemoved(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.paiements.size();
    }
}
