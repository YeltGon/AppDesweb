package com.example.appproyect.Alumno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.appproyect.AdminSQLiteOpenHelper;
import com.example.appproyect.Entidades.Alumno;
import com.example.appproyect.R;
import com.example.appproyect.Utilidades.Utilidades;

import java.util.ArrayList;

public class SpinnerAlumno extends AppCompatActivity {

    Spinner comboalumno;
    ArrayList <String>  listaalumnos;
    ArrayList <Alumno>  alumnosList;

    AdminSQLiteOpenHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_alumno);

        conn=new AdminSQLiteOpenHelper(getApplicationContext(),"bd_prueba",null,1);

        comboalumno= (Spinner) findViewById(R.id.spinneralumno);

        consultarListaAlumnos();

        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter (this,android.R.layout.simple_spinner_item,listaalumnos);

        comboalumno.setAdapter(adaptador);
    }

    private void consultarListaAlumnos() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Alumno persona=null;
        alumnosList = new ArrayList<Alumno>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_ALUMNO,null);

        while (cursor.moveToNext()){

            persona=new Alumno();
            persona.setIdalumno(cursor.getInt(0));
            persona.setNombrealumno(cursor.getString(1));


            alumnosList.add(persona);

        }

        obtenerLista();

    }

    private void obtenerLista() {

        listaalumnos=new ArrayList<String>();
        listaalumnos.add("Seleccione");

        for(int i=0;i<alumnosList.size();i++){
            listaalumnos.add(alumnosList.get(i).getIdalumno()+" - "+alumnosList.get(i).getNombrealumno());
        }
    }
}
