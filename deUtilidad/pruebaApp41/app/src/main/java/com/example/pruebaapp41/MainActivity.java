package com.example.pruebaapp41;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mensaje (View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Tomar una opción");
        alert.setMessage("Que color te gustas más?"
        + "Azul por mar, amarillo por el sol o verde por la hierba");
        alert.setPositiveButton("Azul", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                llamarAzul();
            }
        });
        alert.setNegativeButton("Amarillo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                llamarAmarillo();
            }
        });
        alert.setNeutralButton("Verde", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                llamarVerde();
            }
        });
        alert.show();
        }
    public void llamarAzul(){
        Intent i = new Intent (this, Azul.class);
        startActivity(i);

    }
    public void llamarAmarillo(){
        Intent i = new Intent (this, Amarillo.class);
        startActivity(i);

    }
    public void llamarVerde(){
        Intent i = new Intent (this, Verde.class);
        startActivity(i);
    }
}