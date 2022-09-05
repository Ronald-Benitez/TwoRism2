package com.example.tworism.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tworism.Activities.DetailsActivity;
import com.example.tworism.R;
import com.example.tworism.Retrofit.RecentsDataModel;

import java.util.List;

public class RecentsDataAdapter extends RecyclerView.Adapter<RecentsDataAdapter.viewHolder> {

    String UserId,UserName;
    private List<RecentsDataModel> recentsDataModelList;

    public RecentsDataAdapter(List<RecentsDataModel> recentsDataModelList,String UserId,String UserName) {
        this.recentsDataModelList = recentsDataModelList;
        this.UserId = UserId;
        this.UserName = UserName;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recents_row_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.textViewLugar.setText(recentsDataModelList.get(position).getTravelDestination());
        holder.textViewCiudad.setText(recentsDataModelList.get(position).getTravelOrigin());
        holder.textViewFecha.setText(recentsDataModelList.get(position).getTravelDate());
        holder.textViewPrecio.setText(recentsDataModelList.get(position).getTravelPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                intent.putExtra("UserId",UserId);
                intent.putExtra("UserName",UserName);
                intent.putExtra("TravelId",String.valueOf(recentsDataModelList.get(position).getTravelId()));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recentsDataModelList.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder{

        TextView textViewLugar;
        TextView textViewCiudad;
        TextView textViewPrecio;
        TextView textViewFecha;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textViewLugar = itemView.findViewById(R.id.textViewLugar);
            textViewCiudad = itemView.findViewById(R.id.textViewCiudad);
            textViewPrecio = itemView.findViewById(R.id.textViewPrecio);
            textViewFecha = itemView.findViewById(R.id.textViewFecha);
        }
    }
}
