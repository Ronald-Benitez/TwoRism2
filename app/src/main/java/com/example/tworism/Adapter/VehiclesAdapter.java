package com.example.tworism.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tworism.R;
import com.example.tworism.Retrofit.VehicleInterface;
import com.example.tworism.Retrofit.VehicleModel;
import com.example.tworism.RetrofitClient;
import com.example.tworism.Vehicles.UpdateVehicle;

import java.util.List;

import retrofit2.Call;

public class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.VehiclesViewHolder> {

    List<VehicleModel> vehiclesDataList;
    String UserId, UserName, UserVerified;

    public VehiclesAdapter(List<VehicleModel> vehiclesDataList, String UserId, String UserName, String UserVerified) {
        this.vehiclesDataList = vehiclesDataList;
        this.UserId = UserId;
        this.UserName = UserName;
        this.UserVerified = UserVerified;
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
        Button btnSee,btnDelete;
        TextView tvVehicleTuition,tvVehicleType,tvVehicleCapacity;
        VehicleInterface vehicleInterface = RetrofitClient.getClient().create(VehicleInterface.class);
        public VehiclesViewHolder(@NonNull View itemView) {
            super(itemView);
            btnSee = itemView.findViewById(R.id.btnSee);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            tvVehicleTuition = itemView.findViewById(R.id.tvVehicleTuition);
            tvVehicleType = itemView.findViewById(R.id.tvVehicleType);
            tvVehicleCapacity = itemView.findViewById(R.id.tvVehicleCapacity);

            btnSee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String VehicleId = String.valueOf(vehiclesDataList.get(getAdapterPosition()).getVehicleId());
                    Intent intent = new Intent(view.getContext(), UpdateVehicle.class);
                    intent.putExtra("UserId",UserId);
                    intent.putExtra("UserName",UserName);
                    intent.putExtra("UserVerified",UserVerified);
                    intent.putExtra("VehicleId",VehicleId);
                    view.getContext().startActivity(intent);
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String VehicleId = String.valueOf(vehiclesDataList.get(getAdapterPosition()).getVehicleId());
                    try
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                        builder.setTitle("Eliminar vehiculo");
                        builder.setMessage("¿Estas seguro de eliminar este vehiculo?");
                        builder.setPositiveButton("Si", (dialogInterface, i) -> {
                            Call<Integer> call = vehicleInterface.EliminarV(VehicleId);
                            call.enqueue(new retrofit2.Callback<Integer>() {
                                @Override
                                public void onResponse(Call<Integer> call, retrofit2.Response<Integer> response) {
                                    if(response.isSuccessful())
                                    {
                                        if(response.body() == 1)
                                        {
                                            Toast.makeText(view.getContext(), "Vehiculo eliminado", Toast.LENGTH_SHORT).show();
                                            vehiclesDataList.remove(getAdapterPosition());
                                            notifyItemRemoved(getAdapterPosition());
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<Integer> call, Throwable t) {
                                    Toast.makeText(view.getContext(), "Error al eliminar", Toast.LENGTH_SHORT).show();
                                }
                            });
                        });
                        builder.setNegativeButton("No", (dialogInterface, i) -> {
                            dialogInterface.dismiss();
                        });
                        builder.show();
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(view.getContext(), "Error al eliminar", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
