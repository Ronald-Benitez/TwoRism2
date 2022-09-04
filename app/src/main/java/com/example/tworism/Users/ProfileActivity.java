package com.example.tworism.Users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.tworism.Activities.MainClientActivity;
import com.example.tworism.Provider.ProviderMainActivity;
import com.example.tworism.R;
import com.example.tworism.Retrofit.UserInterface;
import com.example.tworism.Retrofit.UserModel;
import com.example.tworism.RetrofitClient;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    EditText etUserName, etUserEmail, etUserPassword;
    TextView tvUserRating, tvUserType;
    Button btnUpdateUser, btnBack;

    String Procedure, UserId,UserName, UserVerified;
    AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle bundle = getIntent().getExtras();
        UserId = bundle.getString("UserId");
        Procedure = bundle.getString("Procedure");
        UserName = bundle.getString("UserName");
        UserVerified = bundle.getString("UserVerified");

        etUserName = findViewById(R.id.etUserName);
        etUserEmail = findViewById(R.id.etUserEmail);
        etUserPassword = findViewById(R.id.etUserPassword);
        tvUserRating = findViewById(R.id.tvUserRating);
        tvUserType = findViewById(R.id.tvUserType);
        btnUpdateUser = findViewById(R.id.btnUpdateUser);
        btnBack = findViewById(R.id.btnBack);

        awesomeValidation.addValidation(this,R.id.etUserName, ".{3,}",R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.etUserEmail, Patterns.EMAIL_ADDRESS,R.string.invalid_email);
        awesomeValidation.addValidation(this,R.id.etUserPassword, ".{6,}",R.string.invalid_password);

        UserInterface userInterface = RetrofitClient.getClient().create(UserInterface.class);

        try {
            Call<UserModel> call = userInterface.getUser(UserId);
            call.enqueue(new retrofit2.Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        UserModel userModel = response.body();
                        Log.d("User", response.body().toString());
                        try {
                            etUserName.setText(userModel.getUserName());
                            etUserEmail.setText(userModel.getUserEmail());
                            int UserCalification = Integer.parseInt(userModel.getUserCalification());
                            int UserCalifications = Integer.parseInt(userModel.getUserCalifications());
                            if(UserCalification == 0) {
                                tvUserRating.setText("0");
                            } else {
                                tvUserRating.setText(String.valueOf(UserCalification/UserCalifications));
                            }
                            tvUserType.setText(userModel.getUserType());
                        } catch (Exception e) {
                            Toast.makeText(ProfileActivity.this, "Error al cargar los datos", Toast.LENGTH_SHORT).show();
                            Log.e("Error", e.getMessage());
                        }

                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable t) {
                    Toast.makeText(ProfileActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            Toast.makeText(this, "Error al cargar el perfil", Toast.LENGTH_SHORT).show();
            System.out.println(e.getMessage());
        }

        btnUpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()) {
                    try {
                        Map<String,String> body = Map.of(
                                "UserName", etUserName.getText().toString(),
                                "UserEmail", etUserEmail.getText().toString(),
                                "UserPassword", etUserPassword.getText().toString()
                        );
                        Call<List<Integer>> call = userInterface.updateUser(UserId,body);
                        call.enqueue(new Callback<List<Integer>>() {
                            @Override
                            public void onResponse(Call<List<Integer>> call, Response<List<Integer>> response) {
                                if (response.isSuccessful()) {
                                    List<Integer> result = response.body();
                                    if (result.get(0).equals(1)) {
                                        Toast.makeText(ProfileActivity.this,"Usuario actualizado",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(ProfileActivity.this, "Error al actualizar el usuario", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<List<Integer>> call, Throwable t) {
                                System.out.println(t.getMessage());
                            }
                        });
                    } catch (Exception e) {
                        Toast.makeText(ProfileActivity.this, "Error al actualizar el usuario", Toast.LENGTH_SHORT).show();
                        System.out.println(e.getMessage());
                    }
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Procedure.equals("Cliente")) {
                    Intent intent = new Intent(ProfileActivity.this, MainClientActivity.class);
                    intent.putExtra("UserId", UserId);
                    intent.putExtra("UserName", UserName);
                    startActivity(intent);
                    finish();
                } else  {
                    Intent intent = new Intent(ProfileActivity.this, ProviderMainActivity.class);
                    intent.putExtra("UserId", UserId);
                    intent.putExtra("UserName", UserName);
                    intent.putExtra("UserVerified", UserVerified);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    public void onBackPressed() {
        if(Procedure.equals("Cliente")) {
            Intent intent = new Intent(ProfileActivity.this, MainClientActivity.class);
            intent.putExtra("UserId", UserId);
            intent.putExtra("UserName", UserName);
            startActivity(intent);
            finish();
        }else {
            Intent intent = new Intent(ProfileActivity.this, ProviderMainActivity.class);
            intent.putExtra("UserId", UserId);
            intent.putExtra("UserName", UserName);
            intent.putExtra("UserVerified", UserVerified);
            startActivity(intent);
            finish();
        }
    }
}