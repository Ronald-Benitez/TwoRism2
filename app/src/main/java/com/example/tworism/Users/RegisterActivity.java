package com.example.tworism.Users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.tworism.MainActivity;
import com.example.tworism.R;
import com.example.tworism.Retrofit.UserInterface;
import com.example.tworism.Retrofit.UserModel;
import com.example.tworism.RetrofitClient;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {
    Button btnRegister, btnBack;
    EditText etUserEmail, etUserPassword, etUserName;
    Spinner spUserType;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btnRegister);
        btnBack = findViewById(R.id.btnBack);
        etUserEmail = findViewById(R.id.etUserEmail);
        etUserPassword = findViewById(R.id.etUserPassword);
        etUserName = findViewById(R.id.etUserName);
        spUserType = findViewById(R.id.spUserType);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.etUserEmail, Patterns.EMAIL_ADDRESS, R.string.invalid_email);
        awesomeValidation.addValidation(this, R.id.etUserPassword, ".{6,}", R.string.invalid_password);
        awesomeValidation.addValidation(this, R.id.etUserName, ".{3,}", R.string.invalid_name);

        String[] userType = {"Seleccione el tipo", "Proveedor", "Cliente"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, userType);
        spUserType.setAdapter(adapter);

        Retrofit retrofit = RetrofitClient.getClient();
        UserInterface userInterface = retrofit.create(UserInterface.class);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserType = spUserType.getSelectedItem().toString();
                if(awesomeValidation.validate() && (UserType=="Proveedor" || UserType=="Cliente")){
                    String UserEmail = etUserEmail.getText().toString();
                    String UserPassword = etUserPassword.getText().toString();
                    String UserName = etUserName.getText().toString();
                    Map<String, String> params = Map.of("UserEmail", UserEmail, "UserPassword", UserPassword, "UserName", UserName, "UserType", UserType, "UserVerified", "0");
                    Call<UserModel> call = userInterface.register(params);
                    call.enqueue(new retrofit2.Callback<UserModel>() {
                        @Override
                        public void onResponse(Call<UserModel> call, retrofit2.Response<UserModel> response) {
                            UserModel userModel = response.body();
                            if(userModel.getUserEmail()!=null){
                                Toast.makeText(RegisterActivity.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<UserModel> call, Throwable t) {
                            Toast.makeText(RegisterActivity.this, "Error al registrar", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onBackPressed() {
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
    }
}