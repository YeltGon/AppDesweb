package com.example.appproyect.Curso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appproyect.AdminSQLiteOpenHelper;
import com.example.appproyect.Alumno.ConsultaAlumno;
import com.example.appproyect.Alumno.ListViewAlu;
import com.example.appproyect.Alumno.MainAlumno;
import com.example.appproyect.Alumno.RecyclerAlumno;
import com.example.appproyect.Alumno.RegistroAlumno;
import com.example.appproyect.Alumno.SpinnerAlumno;
import com.example.appproyect.R;

public class MainCurso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_curso);

        AdminSQLiteOpenHelper conn=new AdminSQLiteOpenHelper( this, "bd_curso", null, 1);
    }

    public void onClick(View view){
        Intent miIntent=null;
        switch (view.getId()){

            case R.id.btnOpcionRegistrocurso:
                miIntent=new Intent(MainCurso.this, RegistroCurso.class);
                break;

            case R.id.btnconsultacurso:
                miIntent=new Intent(MainCurso.this, ConsultaCurso.class);
                break;

            case R.id.btnConsultaListviewcurso:
                miIntent=new Intent(MainCurso.this, ListViewCurso.class);
                break;

            case R.id.btnListCurso:
                miIntent=new Intent(MainCurso.this, RecyclerCurso.class);
                break;

            case R.id.btnConsultaSpinnercurso:
                miIntent=new Intent(MainCurso.this, SpinnerCurso.class);
                break;
        }


        if (miIntent!=null){
            startActivity(miIntent);}
    }
}
