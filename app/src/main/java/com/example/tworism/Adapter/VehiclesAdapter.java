package com.example.tworism.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tworism.R;
import com.example.tworism.Retrofit.VehicleModel;

import java.util.List;

public class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.VehiclesViewHolder> {

    List<VehicleModel> vehiclesDataList;

    public VehiclesAdapter(List<VehicleModel> vehiclesDataList) {
        this.vehiclesDataList = vehiclesDataList;
    }

    @NonNull
    @Override
    public VehiclesAdapter.VehiclesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_item,parent,false);
        return new VehiclesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiclesAdapter.VehiclesViewHolder holder, int position) {
        holder.tvVehicleCapacity.setText(vehiclesDataList.get(position).getVehicleCapacity());
        holder.tvVehicleTuition.setText(vehiclesDataList.get(position).getVehicleTuition());
        holder.tvVehicleType.setText(vehiclesDataList.get(position).getVehicleType());
    }

    @Override
    public int getItemCount() {
        try
        {
            return vehiclesDataList.size();
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    public class VehiclesViewHolder extends RecyclerView.ViewHolder {
        Button btnSee;
        TextView tvVehicleTuition,tvVehicleType,tvVehicleCapacity;
        public VehiclesViewHolder(@NonNull View itemView) {
            super(itemView);
            btnSee = itemView.findViewById(R.id.btnSee);
            tvVehicleTuition = itemView.findViewById(R.id.tvVehicleTuition);
            tvVehicleType = itemView.findViewById(R.id.tvVehicleType);
            tvVehicleCapacity = itemView.findViewById(R.id.tvVehicleCapacity);

            btnSee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Jhon aqui va tu wea
                    String VehicleId = String.valueOf(vehiclesDataList.get(getAdapterPosition()).getVehicleId());
                }
            });
        }
    }
}
