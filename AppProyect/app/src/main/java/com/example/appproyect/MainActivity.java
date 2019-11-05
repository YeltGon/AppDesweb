package com.example.appproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appproyect.Alumno.MainAlumno;
import com.example.appproyect.Curso.MainCurso;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view){
        Intent miIntent=null;
        switch (view.getId()){

            case R.id.imageButton:
                miIntent=new Intent(MainActivity.this, MainAlumno.class);
                break;


        }

        if (miIntent!=null){
            startActivity(miIntent);}
    }

}
