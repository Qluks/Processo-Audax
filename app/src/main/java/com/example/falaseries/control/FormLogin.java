package com.example.falaseries.control;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.falaseries.R;
import com.example.falaseries.api.U;
import com.example.falaseries.model.User;

import org.json.JSONException;
import org.json.JSONObject;


public class FormLogin extends AppCompatActivity {

    private Button entrar;
    private RequestQueue queue;
    private EditText emailEdit, senhaEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        getSupportActionBar().hide();
        IniciarComponentes();
        login();



        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(FormLogin.this, SerieRegister.class);
                    startActivity(intent);
            }
        });
    }

    private void IniciarComponentes() {
        entrar = findViewById(R.id.login);
        emailEdit = findViewById(R.id.username);
        senhaEdit = findViewById(R.id.password);
        queue = Volley.newRequestQueue(this);
    }

    public void login() {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                U.BASE_URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            User gitUser = new User(
                                    response.getString("email"),
                                    response.getString("password")
                            );
                            setComponents(gitUser);
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
    private void setComponents(User user) {
        emailEdit.setText(user.getEmail());
        senhaEdit.setText(user.getPassword());
    }
}
