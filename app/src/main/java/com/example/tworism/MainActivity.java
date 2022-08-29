package com.example.tworism;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tworism.Retrofit.UserInterface;
import com.example.tworism.Retrofit.UserModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText etUserEmail, etUserPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserEmail = findViewById(R.id.etUserEmail);
        etUserPassword = findViewById(R.id.etUserPassword);
        btnLogin = findViewById(R.id.btnLogin);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-tworism.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserInterface userInterface = retrofit.create(UserInterface.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserEmail = etUserEmail.getText().toString();
                String UserPassword = etUserPassword.getText().toString();

                if(UserEmail.isEmpty() || UserPassword.isEmpty()) {
                    etUserEmail.setError("Email is required");
                    etUserPassword.setError("Password is required");
                } else {
                    try {
                        Call<UserModel> call = userInterface.login(UserEmail, UserPassword);
                        call.enqueue(new retrofit2.Callback<UserModel>() {
                            @Override
                            public void onResponse(Call<UserModel> call, retrofit2.Response<UserModel> response) {
                                UserModel userModel = response.body();
                                Log.d("Dara",response.toString());
                                try {
                                    if (userModel.getUserType().equals("Proveedor")) {
                                        Toast.makeText(MainActivity.this, "Login Successful " + userModel.getUserType(), Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Login Successful " + userModel.getUserType(), Toast.LENGTH_SHORT).show();
                                    }
                                } catch (Exception e) {
                                    Toast.makeText(MainActivity.this, "Inicio de sesión fallido", Toast.LENGTH_SHORT).show();
                                    Log.d("Error", e.getMessage());
                                }
                            }

                            @Override
                            public void onFailure(Call<UserModel> call, Throwable t) {
                                System.out.println(t.getMessage());
                            }
                        });
                    }catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Contraseña o correo invalido", Toast.LENGTH_SHORT).show();
                        Log.i("Error", e.getMessage());
                    }
                }
            }
        });

    }
}