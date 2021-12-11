package com.example.tuprofe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Usuario extends AppCompatActivity {
    private EditText usrId, usrNombre, usrCelular, usrCorreo, usrCiudad, usrDireccion;
    private String  recDescripcion, recAsignatura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        usrId=(EditText)findViewById(R.id.txtIdUsr);
        usrNombre=(EditText)findViewById(R.id.txtNombreUsr);
        usrCelular=(EditText)findViewById(R.id.txtCelUsr);
        usrCorreo=(EditText)findViewById(R.id.txtMailUsr);
        usrCiudad=(EditText)findViewById(R.id.txtCiudadUsr);
        usrDireccion=(EditText)findViewById(R.id.txtDirUsr);
        recAsignatura= getIntent().getStringExtra("materiaTema");
        recDescripcion= getIntent().getStringExtra("descripcionTema");

    }

    public void registrarUsuario(View view){
        AdminSQLiteOpenHelper dbAdmin = new AdminSQLiteOpenHelper(this, "adminDbTuProfe", null, 1);
        SQLiteDatabase dbTuProfe = dbAdmin.getWritableDatabase();

        Integer idUsuario = Integer.parseInt(usrId.getText().toString());
        String nombreUsuario = usrNombre.getText().toString();
        String celUsuario = usrCelular.getText().toString();
        String correoUsuario = usrCorreo.getText().toString();
        String ciudadUsuario = usrCiudad.getText().toString();
        String direccionUsuario= usrDireccion.getText().toString();
        Intent goFecha = new Intent(this, FechaTutoria.class);

        if (!(idUsuario==null && nombreUsuario.isEmpty()
                && celUsuario.isEmpty() && correoUsuario.isEmpty()
                && ciudadUsuario.isEmpty() && direccionUsuario.isEmpty())){

            ContentValues registro = new ContentValues();
            registro.put("id_usuario", idUsuario);
            registro.put("nombre_usuario", nombreUsuario);
            registro.put("celular_usuario", celUsuario);
            registro.put("correo_usuario", correoUsuario);
            registro.put("ciudad_usuario", ciudadUsuario);
            registro.put("direccion_usuario", direccionUsuario);

            dbTuProfe.insert("usuario", null, registro);
            dbTuProfe.close();
            Toast.makeText(this, "Registro exitoso del usuario", Toast.LENGTH_SHORT).show();
            goFecha.putExtra("usuarioId", idUsuario);
            startActivity(goFecha);
        }else{
            Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show();
        }

    }
}