package com.example.tworism;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tworism.Adapter.VehiclesAdapter;
import com.example.tworism.Retrofit.VehicleInterface;
import com.example.tworism.Retrofit.VehicleModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarVehiculos extends AppCompatActivity {

    ArrayList<String> usuarios = new ArrayList<String>();
    RecyclerView listUsu;
    String UserId;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_vehiculos);
        Bundle bundle = getIntent().getExtras();
        UserId = bundle.getString("UserId");
        name = bundle.getString("UserName");

        listUsu = findViewById(R.id.listUsuarios);
        listUsu.setHasFixedSize(true);
        listUsu.setLayoutManager(new LinearLayoutManager(this));

        cargarUsuarios();
    }

    public void cargarUsuarios(){
        VehicleInterface api = RetrofitClient.getClient().create(VehicleInterface.class);
        try {
            Call<List<VehicleModel>> call = api.listaUsuarios(UserId);
            call.enqueue(new Callback<List<VehicleModel>>() {
                @Override
                public void onResponse(Call<List<VehicleModel>> call, Response<List<VehicleModel>> response) {
                    List<VehicleModel> lista = response.body();
                    VehiclesAdapter adapter = new VehiclesAdapter(lista);
                    listUsu.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<VehicleModel>> call, Throwable t) {

                }
            });
        }catch (Exception e){
            Toast.makeText(this, "Error al cargar los vehiculos", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}