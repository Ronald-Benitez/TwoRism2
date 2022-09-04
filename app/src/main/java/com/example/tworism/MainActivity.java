package com.example.tworism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.tworism.Activities.MainClientActivity;
import com.example.tworism.Provider.ProviderMainActivity;
import com.example.tworism.Retrofit.UserInterface;
import com.example.tworism.Retrofit.UserModel;
import com.example.tworism.Users.RegisterActivity;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    EditText etUserEmail, etUserPassword;
    Button btnLogin, btnRegister;
    AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserEmail = findViewById(R.id.etUserEmail);
        etUserPassword = findViewById(R.id.etUserPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        awesomeValidation.addValidation(this,R.id.etUserEmail, Patterns.EMAIL_ADDRESS,R.string.invalid_email);
        awesomeValidation.addValidation(this,R.id.etUserPassword, ".{6,}",R.string.invalid_password);

        Retrofit retrofit = RetrofitClient.getClient();

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
                                try {
                                    if (userModel.getUserType().equals("Proveedor")) {
                                        Toast.makeText(MainActivity.this, "Bienvenido "+userModel.getUserName(), Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(MainActivity.this, ProviderMainActivity.class);
                                        intent.putExtra("UserName", userModel.getUserName());
                                        intent.putExtra("UserId", userModel.getUserId());
                                        intent.putExtra("UserVerified", String.valueOf(userModel.getUserVerified()));
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(MainActivity.this, "Bienvenido "+userModel.getUserName(), Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(MainActivity.this, MainClientActivity.class));
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

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

    }
}