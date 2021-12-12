package com.example.tuprofe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MensajeFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje_final);
    }

    public void regresar(View view){
        Intent goInicio = new Intent(this, MainActivity.class);
        startActivity(goInicio);

    }
}