package com.example.falaseries.control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.falaseries.R;
import com.squareup.picasso.Picasso;

public class RegisterDone extends AppCompatActivity {

    private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_done);

        getSupportActionBar().hide();
        IniciarComponents();


        ImageView image_logo_solo = findViewById(R.id.logo_solo);
        Picasso.with(this).load(R.drawable.logo_solo);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterDone.this, SerieRegister.class);
                startActivity(intent);
            }
        });

    }
    private void IniciarComponents() {
        ok = findViewById(R.id.ok);
    }
}