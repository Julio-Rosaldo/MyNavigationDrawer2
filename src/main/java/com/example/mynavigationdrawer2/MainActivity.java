package com.example.mynavigationdrawer2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    // En mobile_navigation agregar el fragment de destino,
    // Despues en activity_main_drawer agregar el elemento en el xml,
    // Y colocar en mismo id generado en mobile_navigation.

    //Para eliminar la flecha de retorno en el fragment agregado, agregar en mAppBarConfiguration el id del fragment generado en mobile_navigation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        boolean Sesion = preferencias.getBoolean("sesion", false);
        /*
        if(!Sesion){
            Intent intent = new Intent(this, Inicio.class);
            startActivity(intent);
            finish();
        }

         */
        //String user = getIntent().getStringExtra("user");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.myTabbedFragment, R.id.exitFragment)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("¿Esta seguro que desea salir?");
        builder.setTitle("Cerrar sesion");

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(MainActivity.this, "Operacion exitosa", Toast.LENGTH_LONG).show();

                SharedPreferences preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                //editor.putString("usuario", TxtUsuario.getText().toString());
                //editor.putString("contrasena", TxtContrasena.getText().toString());
                editor.putBoolean("sesion", false);
                editor.commit();

                Intent intent = new Intent(MainActivity.this, Inicio.class);
                startActivity(intent);
                finish();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Do nothing
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();


        Intent intent = new Intent(MainActivity.this, Inicio.class);
        startActivity(intent);
        finish();
    }
}