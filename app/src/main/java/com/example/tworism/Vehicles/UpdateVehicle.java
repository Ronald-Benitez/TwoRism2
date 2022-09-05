package com.example.tworism.Vehicles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tworism.ListarVehiculos;
import com.example.tworism.R;
import com.example.tworism.Retrofit.VehicleInterface;
import com.example.tworism.Retrofit.VehicleModel;
import com.example.tworism.RetrofitClient;
import com.example.tworism.Users.ProfileActivity;

import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class UpdateVehicle extends AppCompatActivity {
    String UserId;
    Button btnUpdate, btnBack;
    EditText etVehicleType, etVehicleCapacity, etVehicleTuition;
    String UserName, UserVerified,VehicleId;
    VehicleInterface vehicleInterface = RetrofitClient.getClient().create(VehicleInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_vehicle);
        Bundle bundle = getIntent().getExtras();
        UserId = bundle.getString("UserId");
        UserName = bundle.getString("UserName");
        UserVerified = bundle.getString("UserVerified");
        VehicleId = bundle.getString("VehicleId");

        btnUpdate = findViewById(R.id.btnUpdate);
        btnBack = findViewById(R.id.btnBack);
        etVehicleType = findViewById(R.id.etVehicleType);
        etVehicleCapacity = findViewById(R.id.etVehicleCapacity);
        etVehicleTuition = findViewById(R.id.etVehicleTuition);

        loadData();

        btnUpdate.setOnClickListener(v -> {

            updateVehicle();
        });

        btnBack.setOnClickListener(v -> {
            back();
        });

    }

    public void onBackPressed() {
        super.onBackPressed();
        back();
        finish();
    }

    public void loadData(){
        try {
            Call<VehicleModel> call = vehicleInterface.BuscarV(VehicleId);
            call.enqueue(new retrofit2.Callback<VehicleModel>() {
                @Override
                public void onResponse(Call<VehicleModel> call, retrofit2.Response<VehicleModel> response) {
                    VehicleModel vehicleModel = response.body();
                    etVehicleType.setText(vehicleModel.getVehicleType());
                    etVehicleCapacity.setText(vehicleModel.getVehicleCapacity());
                    etVehicleTuition.setText(vehicleModel.getVehicleTuition());
                }
                @Override
                public void onFailure(Call<VehicleModel> call, Throwable t) {
                    Toast.makeText(UpdateVehicle.this, "Error al cargar los datos", Toast.LENGTH_SHORT).show();
                    back();
                }
            });

        }catch (Exception e){
            Toast.makeText(this, "Error al cargar los datos", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            back();

        }
    }

    public void back(){
        Intent intent = new Intent(UpdateVehicle.this, ListarVehiculos.class);
        intent.putExtra("UserId", UserId);
        intent.putExtra("UserName", UserName);
        intent.putExtra("UserVerified", UserVerified);
        startActivity(intent);
    }

    public void updateVehicle(){
        try{
            String VehicleType = etVehicleType.getText().toString();
            String VehicleCapacity = etVehicleCapacity.getText().toString();
            String VehicleTuition = etVehicleTuition.getText().toString();
            Map<String,String> map = Map.of("VehicleType", VehicleType, "VehicleCapacity", VehicleCapacity, "VehicleTuition", VehicleTuition);

            Call<List<String>> call = vehicleInterface.ModificarV(VehicleId, map);
            call.enqueue(new retrofit2.Callback<List<String>>() {
                @Override
                public void onResponse(Call<List<String>> call, retrofit2.Response<List<String>> response) {
                    List<String> result = response.body();
                    if (result.get(0).equals("1")){
                        Toast.makeText(UpdateVehicle.this,"Vehiculo actualizado",Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(UpdateVehicle.this, "Error al actualizar el vehiculo 1", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<List<String>> call, Throwable t) {
                    Toast.makeText(UpdateVehicle.this, "Error al actualizar el vehiculo", Toast.LENGTH_SHORT).show();
                    Log.d("result", t.getMessage());
                    back();
                }
            });

        }catch (Exception e){
            Toast.makeText(this, "Error al actualizar el vehiculo", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            Log.d("Error", e.getMessage());
            back();
        }
    }
}