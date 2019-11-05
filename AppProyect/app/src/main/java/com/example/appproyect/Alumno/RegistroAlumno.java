package com.example.appproyect.Alumno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.appproyect.AdminSQLiteOpenHelper;
import com.example.appproyect.R;
import com.example.appproyect.Utilidades.Utilidades;

public class RegistroAlumno extends AppCompatActivity {
    EditText campoidalumno, camponombrealumno;
    AdminSQLiteOpenHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alumno);

        campoidalumno= (EditText) findViewById(R.id.campoidalumno);
        camponombrealumno= (EditText) findViewById(R.id.camponombrealumno);

        conn=new AdminSQLiteOpenHelper(getApplicationContext(), "bd_prueba", null, 1);
    }

    public void onClick(View view) {
        registrarAlumno();
    }

    private void registrarAlumno() {
        try {


            SQLiteDatabase db = conn.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Utilidades.CAMPO_ID, campoidalumno.getText().toString());
            values.put(Utilidades.CAMPO_NOMBRE, camponombrealumno.getText().toString());


            Long idResultante = db.insert(Utilidades.TABLA_ALUMNO, Utilidades.CAMPO_ID, values);
            Toast.makeText(getApplicationContext(), "Registro Exitoso:" + idResultante, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
