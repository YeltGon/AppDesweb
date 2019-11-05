package com.example.appproyect.Curso;

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

public class RegistroCurso extends AppCompatActivity {

    EditText campoidcurso, camponombrecurso;
    AdminSQLiteOpenHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_curso);

        campoidcurso= (EditText) findViewById(R.id.campoidcurso);
        camponombrecurso= (EditText) findViewById(R.id.camponombrecurso);

        conn=new AdminSQLiteOpenHelper(getApplicationContext(), "bd_curso", null, 1);
    }

    public void onClick(View view) {
        registrarCurso();
    }

    private void registrarCurso() {
        try {


            SQLiteDatabase db = conn.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Utilidades.CAMPO_IDCURSO, campoidcurso.getText().toString());
            values.put(Utilidades.CAMPO_NOMBRECURSO, camponombrecurso.getText().toString());


            Long idResultante = db.insert(Utilidades.TABLA_CURSO, Utilidades.CAMPO_IDCURSO, values);
            Toast.makeText(getApplicationContext(), "Registro Exitoso:" + idResultante, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
