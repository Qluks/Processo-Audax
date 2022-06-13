package com.example.falaseries.control;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.falaseries.R;
import com.example.falaseries.model.Series;

public class Registration extends AppCompatActivity {

    private ImageButton voltar;
    private View Cancel;
    private TextView Cancel_1;
    private Button Cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().hide();

        IniciarComponentes();

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, SerieRegister.class);
                startActivity(intent);
            }
        });
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this,SerieRegister.class);
                startActivity(intent);
            }
        });
        Cancel_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this,SerieRegister.class);
                startActivity(intent);
            }
        });
        Cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, RegisterDone.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes() {
        voltar = findViewById(R.id.back);
        Cadastrar = findViewById(R.id.serieNova);
        Cancel = findViewById(R.id.cancel_button);
        Cancel_1 = findViewById(R.id.cancel_button_1);
    }
}