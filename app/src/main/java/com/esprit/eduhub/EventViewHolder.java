package com.esprit.eduhub;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventViewHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView lieuList, titreList,DescList,detailtype,detailstatus,detaildate,detaildescription;
    Button eventdetails;

    public EventViewHolder(@NonNull View itemView){
        super(itemView);
        img=itemView.findViewById(R.id.img);
        titreList=itemView.findViewById(R.id.titreList);
        lieuList=itemView.findViewById(R.id.lieuList);
        detaildescription=itemView.findViewById(R.id.detaildescription);
        detaildate=itemView.findViewById(R.id.detaildate);
        detailstatus=itemView.findViewById(R.id.detailstatus);
        detailtype=itemView.findViewById(R.id.detailtype);
        eventdetails=itemView.findViewById(R.id.eventdetails);
    }
}