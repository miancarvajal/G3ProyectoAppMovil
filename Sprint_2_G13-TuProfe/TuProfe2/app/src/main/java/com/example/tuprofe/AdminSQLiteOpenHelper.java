package com.example.tuprofe;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bdTuProfe) {
        bdTuProfe.execSQL("create table usuario(id_usuario int, nombre text, celular text, correo_e text, id_ciudad int, direccion String," +
                            "PRIMARY KEY (id_usuario))");
        bdTuProfe.execSQL("create table departamento(id_departamento int, nombre text," +
                            "PRIMARY KEY (id_departamento))");
        bdTuProfe.execSQL("create table ciudad(id_ciudad int, id_departamento int, nombre text," +
                            "PRIMARY KEY (id_ciudad), " +
                            "FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento))");
        bdTuProfe.execSQL("create table asignatura(id_asignatura int, id_profe int, descripcion text)");
        bdTuProfe.execSQL("create table profe(id_profe int, nombre text, edad int, id_ciudad int, id_departamento int, usuario text, contrasena text," +
                            "PRIMARY KEY (id_profe)," +
                            "FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento)," +
                            "FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad))");
        bdTuProfe.execSQL("create table asesoria(id_asesoria int, tema text, fecha date, hora time, id_profe int, id_usuario," +
                "PRIMARY KEY (id_asesoria)," +
                "FOREIGN KEY (id_profe) REFERENCES profe(id_profe)," +
                "FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
