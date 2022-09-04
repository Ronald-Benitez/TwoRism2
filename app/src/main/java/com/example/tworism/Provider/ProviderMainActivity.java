package com.example.tworism.Provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tworism.R;
import com.example.tworism.RegistrarVehiculo;

public class ProviderMainActivity extends AppCompatActivity {
    Button btnAddVehicle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_main);
        Bundle bundle = getIntent().getExtras();
        String UserId = bundle.getString("UserId");
        String UserName = bundle.getString("UserName");

        btnAddVehicle = findViewById(R.id.btnAddVehicle);

        btnAddVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProviderMainActivity.this, RegistrarVehiculo.class);
                intent.putExtra("UserId", UserId);
                intent.putExtra("UserName", UserName);
                startActivity(intent);
            }
        });

    }
}