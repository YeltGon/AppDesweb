package com.example.appproyect.Curso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.appproyect.AdminSQLiteOpenHelper;

import com.example.appproyect.Entidades.Curso;
import com.example.appproyect.R;
import com.example.appproyect.Recycler.AdapterCursoLista;
import com.example.appproyect.Utilidades.Utilidades;

import java.util.ArrayList;

public class RecyclerCurso extends AppCompatActivity {

    ArrayList<Curso> listaCurso;
    RecyclerView recyclerViewCurso;

    AdminSQLiteOpenHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_curso);

        try{
            conn=new AdminSQLiteOpenHelper(getApplicationContext(), "bd_curso",null,1);

            listaCurso = new ArrayList<>();
            recyclerViewCurso = findViewById(R.id.IdRecyclerCurso);

            recyclerViewCurso.setLayoutManager(new LinearLayoutManager(this));

            consultarListaCurso();

            AdapterCursoLista adapter = new AdapterCursoLista(listaCurso);
            recyclerViewCurso.setAdapter(adapter);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG ).show();
        }

    }


    private void consultarListaCurso() {
        SQLiteDatabase db=conn.getReadableDatabase();
        Curso curso =null;

        Cursor cursor=db.rawQuery("Select * from " + Utilidades.TABLA_CURSO, null);

        while(cursor.moveToNext()){
            curso = new Curso();
            curso.setIdcurso(cursor.getInt(0));
            curso.setNombrecurso(cursor.getString(1));

            listaCurso.add(curso);

        }
    }
}
