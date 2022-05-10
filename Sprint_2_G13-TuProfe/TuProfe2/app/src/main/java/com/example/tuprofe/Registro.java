package com.example.tuprofe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText prCodigo, prNombre, prEdad, prCiudad, prDepartamento, prUsuario, prContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        prCodigo=(EditText)findViewById(R.id.txtIdProfe);
        prNombre=(EditText)findViewById(R.id.txtNombreProfe);
        prEdad=(EditText)findViewById(R.id.txtEdad);
        prCiudad=(EditText)findViewById(R.id.txtCiudadProfe);
        prDepartamento=(EditText)findViewById(R.id.txtDepartamentoProfe);
        prUsuario=(EditText)findViewById(R.id.txtNombreUsuarioProfe);
        prContrasena=(EditText)findViewById(R.id.txtPassProfe);
    }

    public void registrarProfesor(View view){
        AdminSQLiteOpenHelper dbAdmin = new AdminSQLiteOpenHelper(this, "adminDbTuProfe", null, 1);
        SQLiteDatabase dbTuProfe = dbAdmin.getWritableDatabase();

        Integer idProfe = Integer.parseInt(prCodigo.getText().toString());
        String nombreProfe = prNombre.getText().toString();
        Integer edad = Integer.parseInt(prCodigo.getText().toString());
        String ciudadProfe = prCiudad.getText().toString();
        String departamentoProfe = prDepartamento.getText().toString();
        String usuarioiProfe = prUsuario.getText().toString();
        String contrasena= prContrasena.getText().toString();

        if (!(idProfe==null && nombreProfe.isEmpty() && edad== null
                 && ciudadProfe.isEmpty() && departamentoProfe.isEmpty()
                 && usuarioiProfe.isEmpty() && contrasena.isEmpty())){

            ContentValues registro = new ContentValues();
            registro.put("id_profe", idProfe);
            registro.put("nombre", nombreProfe);
            registro.put("edad", edad);
            registro.put("id_ciudad", ciudadProfe);
            registro.put("id_departamento", departamentoProfe);
            registro.put("usuario", usuarioiProfe);
            registro.put("contrasena", contrasena);

            dbTuProfe.insert("profe", null, registro);
            dbTuProfe.close();
            Toast.makeText(this, "Registro exitoso del profesor", Toast.LENGTH_SHORT).show();
            Intent goProfes = new Intent(this, Profes.class);
            startActivity(goProfes);
        }else{
            Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show();
        }

    }
}