package com.example.appproyect.Curso;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.appproyect.AdminSQLiteOpenHelper;
import com.example.appproyect.Entidades.Alumno;
import com.example.appproyect.Entidades.Curso;
import com.example.appproyect.R;
import com.example.appproyect.Utilidades.Utilidades;

import java.util.ArrayList;

public class SpinnerCurso extends AppCompatActivity {

    Spinner combocurso;
    ArrayList<String> listacursos;
    ArrayList <Curso>  cursosList;

    AdminSQLiteOpenHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_curso);

        conn=new AdminSQLiteOpenHelper(getApplicationContext(),"bd_curso",null,1);

        combocurso= (Spinner) findViewById(R.id.spinnercurso);

        consultarListaCursos();

        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter (this,android.R.layout.simple_spinner_item,listacursos);

        combocurso.setAdapter(adaptador);
    }

    private void consultarListaCursos() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Curso curso=null;
        cursosList = new ArrayList<Curso>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_CURSO,null);

        while (cursor.moveToNext()){

            curso=new Curso();
            curso.setIdcurso(cursor.getInt(0));
            curso.setNombrecurso(cursor.getString(1));


            cursosList.add(curso);

        }

        obtenerLista();

    }

    private void obtenerLista() {

        listacursos=new ArrayList<String>();
        listacursos.add("Seleccione");

        for(int i=0;i<cursosList.size();i++){
            listacursos.add(cursosList.get(i).getIdcurso()+" - "+cursosList.get(i).getNombrecurso());
        }
    }
}
