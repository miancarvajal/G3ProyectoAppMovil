package com.example.tuprofe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;


public class FechaTutoria extends AppCompatActivity {
 TextView tvFecha;
 Button btnFecha;
 Calendar fec;
 DatePickerDialog dpFecha;
 String fech, descTema, asignatura, strIdUsr;
 String hora;
 int idUsr;
 CheckBox hora1, hora2, hora3, hora4, hora5, hora6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha_tutoria);
        getIntent().getIntExtra("usuarioId", idUsr);
        tvFecha = (TextView) findViewById(R.id.txtDate);
        btnFecha = (Button) findViewById(R.id.btnFecha);
        asignatura= getIntent().getStringExtra("materiaTema");
        descTema= getIntent().getStringExtra("descripcionTema");

        hora1 = (CheckBox) findViewById(R.id.chkHora1);
        hora2 = (CheckBox) findViewById(R.id.chkHora2);
        hora3 = (CheckBox) findViewById(R.id.chkHora3);
        hora4 = (CheckBox) findViewById(R.id.chkHora4);
        hora5 = (CheckBox) findViewById(R.id.chkHora5);
        hora6 = (CheckBox) findViewById(R.id.chkHora6);

        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             fec= Calendar.getInstance();
             int day = fec.get(Calendar.DAY_OF_MONTH);
             int month = fec.get(Calendar.MONTH);
             int year = fec.get(Calendar.YEAR);
             dpFecha=new DatePickerDialog(FechaTutoria.this, new DatePickerDialog.OnDateSetListener() {
                 @Override
                 public void onDateSet(DatePicker view, int year, int month, int day) {
                    tvFecha.setText(day + "/" + month + "/" + year);
                    fech = (day + "/" + month + "/" + year);
                 }
             }, day, month, year);
             dpFecha.show();


            }

        });
    }

    public void seleccionFecha1(View view){
        hora = "8:00am";
        hora1.setChecked(true);
        hora2.setChecked(false);
        hora3.setChecked(false);
        hora4.setChecked(false);
        hora5.setChecked(false);
        hora6.setChecked(false);
    }
    public void seleccionFecha2(View view){
        hora = "10:00am";
        hora2.setChecked(true);
        hora1.setChecked(false);
        hora3.setChecked(false);
        hora4.setChecked(false);
        hora5.setChecked(false);
        hora6.setChecked(false);
    }

    public void seleccionFecha3(View view){
        hora = "12:00am";
        hora3.setChecked(true);
        hora2.setChecked(false);
        hora1.setChecked(false);
        hora4.setChecked(false);
        hora5.setChecked(false);
        hora6.setChecked(false);
    }
    public void seleccionFecha4(View view){
        hora = "2:00pm";
        hora4.setChecked(true);
        hora2.setChecked(false);
        hora3.setChecked(false);
        hora1.setChecked(false);
        hora5.setChecked(false);
        hora6.setChecked(false);
    }
    public void seleccionFecha5(View view){
        hora = "4:00pm";
        hora5.setChecked(true);
        hora2.setChecked(false);
        hora3.setChecked(false);
        hora4.setChecked(false);
        hora1.setChecked(false);
        hora6.setChecked(false);
    }

    public void seleccionFecha6(View view){
        hora = "6:00pm";
        hora6.setChecked(true);
        hora2.setChecked(false);
        hora3.setChecked(false);
        hora4.setChecked(false);
        hora5.setChecked(false);
        hora1.setChecked(false);
    }

    public void RegistrarTutoria(View view){
        AdminSQLiteOpenHelper dbAdmin = new AdminSQLiteOpenHelper(this, "adminDbTuProfe", null, 1);
        SQLiteDatabase dbTuProfe = dbAdmin.getWritableDatabase();

        Integer idUsuario = idUsr;

        if (!(idUsuario == null && fech.isEmpty() && hora.isEmpty())){

            ContentValues registro = new ContentValues();
            registro.put("id_usuario", idUsuario);
            registro.put("fecha", fech);
            registro.put("hora", hora);

            dbTuProfe.insert("tutorias", null, registro);
            dbTuProfe.close();
            Toast.makeText(this, "Registro exitoso de la tutoria", Toast.LENGTH_SHORT).show();
            Intent goInicio = new Intent(this, MainActivity.class);
            startActivity(goInicio);
        }else{
            Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show();
        }

    }
}