package com.example.tuprofe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EleccionTema extends AppCompatActivity {

    ListView lstAsignature;
    ArrayAdapter<String> adaptAsignatura;
    String materia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion_tema);

        ArrayList<String> lstMateria= new ArrayList<String>();
        lstMateria.add("Español");
        lstMateria.add("Matematicas");
        lstMateria.add("Fisica");
        lstMateria.add("Quimica");
        lstMateria.add("Ingles");
        lstMateria.add("Sociales");
        lstMateria.add("Informatica");

        lstAsignature = (ListView)findViewById(R.id.lvAsignaturas);

        adaptAsignatura = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lstMateria);

        lstAsignature.setAdapter(adaptAsignatura);

        Intent pasoVariables = new Intent(this, DescripcionTema.class);

        lstAsignature.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                materia = lstMateria.get(position);
                pasoVariables.putExtra("materiaTema", materia);
                startActivity(pasoVariables);
            }
        });
    }
}