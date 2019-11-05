package com.example.appproyect.Alumno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.appproyect.AdminSQLiteOpenHelper;
import com.example.appproyect.Entidades.Alumno;
import com.example.appproyect.R;
import com.example.appproyect.Recycler.AdapterAlumnoLista;
import com.example.appproyect.Utilidades.Utilidades;

import java.util.ArrayList;

public class RecyclerAlumno extends AppCompatActivity {

    ArrayList<Alumno> listaAlumno;
    RecyclerView recyclerViewAlumno;

    AdminSQLiteOpenHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_alumno);

        try{
            conn=new AdminSQLiteOpenHelper(getApplicationContext(), "bd_prueba",null,1);

            listaAlumno = new ArrayList<>();
            recyclerViewAlumno = findViewById(R.id.IdRecyclerAlumno);

            recyclerViewAlumno.setLayoutManager(new LinearLayoutManager(this));

            consultarListaAlumno();

            AdapterAlumnoLista adapter = new AdapterAlumnoLista(listaAlumno);
            recyclerViewAlumno.setAdapter(adapter);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG ).show();
        }




    }

    private void consultarListaAlumno() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Alumno alumno =null;

        Cursor cursor=db.rawQuery("Select * from " + Utilidades.TABLA_ALUMNO, null);

        while(cursor.moveToNext()){
            alumno = new Alumno();
            alumno.setIdalumno(cursor.getInt(0));
            alumno.setNombrealumno(cursor.getString(1));

            listaAlumno.add(alumno);

        }
    }
    }

