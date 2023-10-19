package com.example.conneccar.Ac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conneccar.services.UsuarioService;
import com.example.conneccar.R;

import org.json.JSONArray;

public class LoginAc extends AppCompatActivity {

    EditText edEmail;
    EditText edSenha;
    Button btLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        edEmail = findViewById(R.id.edLogEmail);
        edSenha = findViewById(R.id.edLogSenha);
        btLogin = findViewById(R.id.btnLogin);

        Intent HomeIntent = new Intent(getApplicationContext(), HomeAc.class);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UsuarioService usuarioService = new UsuarioService(LoginAc.this);

                usuarioService.usuarioLogin(edEmail.getText().toString(), edSenha.getText().toString(), new UsuarioService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(LoginAc.this, message, Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(JSONArray response) {
                        System.out.println(response);
                        startActivity(HomeIntent);
                    }
                });

            }
        });

    }
}