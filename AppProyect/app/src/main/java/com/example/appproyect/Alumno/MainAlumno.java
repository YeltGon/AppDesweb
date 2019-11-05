package com.example.appproyect.Alumno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appproyect.AdminSQLiteOpenHelper;
import com.example.appproyect.MainActivity;
import com.example.appproyect.R;

public class MainAlumno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alumno);

        AdminSQLiteOpenHelper conn=new AdminSQLiteOpenHelper( this, "bd_prueba", null, 1);
    }
    public void onClick(View view){
        Intent miIntent=null;
        switch (view.getId()){

            case R.id.btnOpcionRegistro:
                miIntent=new Intent(MainAlumno.this, RegistroAlumno.class);
                break;

            case R.id.btnconsultalu:
                miIntent=new Intent(MainAlumno.this, ConsultaAlumno.class);
                break;

            case R.id.btnConsultaListview:
                miIntent=new Intent(MainAlumno.this, ListViewAlu.class);
                break;

            case R.id.btnListAlumno:
                miIntent=new Intent(MainAlumno.this, RecyclerAlumno.class);
                break;

            case R.id.btnConsultaSpinner:
                miIntent=new Intent(MainAlumno.this, SpinnerAlumno.class);
                break;
        }


        if (miIntent!=null){
            startActivity(miIntent);}
    }
    }

