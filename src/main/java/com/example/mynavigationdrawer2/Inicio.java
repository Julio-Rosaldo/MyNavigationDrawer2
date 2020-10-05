package com.example.mynavigationdrawer2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void iniciar(View view){
        SharedPreferences preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        //editor.putString("usuario", TxtUsuario.getText().toString());
        //editor.putString("contrasena", TxtContrasena.getText().toString());
        editor.putBoolean("sesion", true);
        editor.commit();

        int doge = 11;

        Intent intent = new Intent(this, MainActivity.class);
        //String user = "julio";
        //intent.putExtra("user", user);
        startActivity(intent);
        finish();
    }
}