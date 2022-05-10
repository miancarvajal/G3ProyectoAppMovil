package com.example.tuprofe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DescripcionTema extends AppCompatActivity {

    String descripcionTema;
    String recAsignatura;
    EditText descripcionAsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_tema);
        descripcionAsg = findViewById(R.id.txtDescripcion);
        recAsignatura= getIntent().getStringExtra("materiaTema");



    }

    public void continuar(View view){
        Intent goUsuario = new Intent(this, Usuario.class);
        descripcionTema=descripcionAsg.getText().toString();
        goUsuario.putExtra("materiaTema", recAsignatura);
        goUsuario.putExtra("descripcionTema", descripcionTema);
        startActivity(goUsuario);

    }
}