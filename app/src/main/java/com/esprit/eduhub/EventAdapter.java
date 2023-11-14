package com.esprit.eduhub;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esprit.eduhub.entity.Evenement;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {


    private Context context;
    private List<Evenement> events;

    public EventAdapter(List<Evenement> events, Context ctx) {
        this.context=ctx;
        this.events = events;
    }


    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_single_item,parent,false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.titreList.setText(events.get(position).getTitre());
        holder.lieuList.setText(events.get(position).getLieu());
        holder.img.setImageResource(events.get(position).getImg());
        holder.eventdetails.setOnClickListener(v -> {
            Intent intent =new Intent(context,EventDetails.class);
            intent.putExtra("id", events.get(position).getId());
            intent.putExtra("titreList",events.get(position).getTitre());
            intent.putExtra("lieuList",events.get(position).getLieu());
            intent.putExtra("img",events.get(position).getImg());
            intent.putExtra("detaildate",events.get(position).getDate());
            intent.putExtra("detaildescription",events.get(position).getDescription());
            intent.putExtra("detailtype",events.get(position).getStatus());
            intent.putExtra("detailstatus",events.get(position).getStatus());
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
