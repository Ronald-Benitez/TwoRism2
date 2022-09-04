package com.example.tworism.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tworism.Activities.DetailsActivity;
import com.example.tworism.Models.RecentsModel;
import com.example.tworism.R;

import java.util.List;

public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.RecentsViewHolder> {

    Context context;
    List<RecentsModel> recentsDataList;

    public RecentsAdapter(Context context, List<RecentsModel> recentsDataList) {
        this.context = context;
        this.recentsDataList = recentsDataList;
    }

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recents_row_item,parent,false);

        //aqui creamos un recyclerview row item layout
        return new RecentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsViewHolder holder, int position) {

        holder.place.setText(recentsDataList.get(position).getPlaceName());
        holder.city.setText(recentsDataList.get(position).getCity());
        holder.price.setText(recentsDataList.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, DetailsActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recentsDataList.size();
    }


    public static final class RecentsViewHolder extends RecyclerView.ViewHolder{

        TextView place,city,price;

        public RecentsViewHolder(@NonNull View itemView){
            super(itemView);

            place = itemView.findViewById(R.id.textViewLugar);
            city = itemView.findViewById(R.id.textViewCiudad);
            price = itemView.findViewById(R.id.textViewPrecio);
        }
    }
}
