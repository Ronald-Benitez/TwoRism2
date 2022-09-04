package com.example.tworism;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tworism.Retrofit.VehicleInterface;
import com.example.tworism.Retrofit.VehicleModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarVehiculos extends AppCompatActivity {

    ArrayList<String> usuarios = new ArrayList<String>();
    ListView listUsu;
    ArrayAdapter adaptador;
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
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, usuarios);
        listUsu.setAdapter(adaptador);

        cargarUsuarios();
    }

    public void cargarUsuarios(){
        VehicleInterface api = RetrofitClient.getClient().create(VehicleInterface.class);
        Call<List<VehicleModel>> call = api.listaUsuarios(UserId);
        call.enqueue(new Callback<List<VehicleModel>>() {
            @Override
            public void onResponse(Call<List<VehicleModel>> call, Response<List<VehicleModel>> response) {
                List<VehicleModel> lista = response.body();
                for (VehicleModel x:lista){
                    usuarios.add("Vehicle ID: "+String.valueOf(x.getVehicleId())+" \n  Nombre: "+ x.getVehicleType()+ "   Id: "+x.getVehicleTuition());
                }
                adaptador.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<VehicleModel>> call, Throwable t) {

            }
        });
    }
}