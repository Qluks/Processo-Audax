package com.example.falaseries.control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.falaseries.R;
import com.example.falaseries.api.U;

import org.json.JSONException;
import org.json.JSONObject;


public class SerieDescription extends AppCompatActivity {

    private View editar;
    private TextView editar_1, Description, Titulo;
    private ImageButton voltar;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie_description);

        getSupportActionBar().hide();

        IniciarComponente();

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SerieDescription.this, Registration.class);
                startActivity(intent);
            }
        });
        editar_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SerieDescription.this,Registration.class);
                startActivity(intent);
            }
        });
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SerieDescription.this, SerieRegister.class);
                startActivity(intent);
            }
        });

    }
    private void IniciarComponente() {
        editar = findViewById(R.id.edit);
        editar_1 = findViewById(R.id.edit_1);
        voltar = findViewById(R.id.back_description);
        Titulo = findViewById(R.id.Text_Cadastro);
        Description = findViewById(R.id.Description);
        queue = Volley.newRequestQueue(this);
    }

    private void requestSeries() {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                U.BASE_URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Series gitSerie = new Series(
                                    response.getString("descricao"),
                                    response.getString("titulo")
                            );
                            setComponents(gitSerie);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        queue.add(request);
    }

    private void setComponents(Series series) {
        Titulo.setText(series.getTitulo());
        Description.setText(series.getDescricao());
    }
}