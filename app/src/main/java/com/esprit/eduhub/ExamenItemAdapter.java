package com.esprit.eduhub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.eduhub.entity.Examen;

import java.util.ArrayList;

public class ExamenItemAdapter extends RecyclerView.Adapter<ExamenItemHolder> {
    ArrayList<Examen> examens;

    public ExamenItemAdapter(ArrayList<Examen> examens) {
        this.examens = examens;
    }

    @NonNull
    @Override
    public ExamenItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.examen_item,parent,false);
        return new ExamenItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamenItemHolder holder, int position) {
        holder.examenTitre.setText(examens.get(position).getNom());
        //holder.niveauDiff.setText(examens.get(position).getNiveauDiff());

    }

    @Override
    public int getItemCount() {

        return this.examens.size();
    }
}
