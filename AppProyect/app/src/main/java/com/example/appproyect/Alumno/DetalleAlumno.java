package com.example.appproyect.Alumno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appproyect.Entidades.Alumno;
import com.example.appproyect.R;

public class DetalleAlumno extends AppCompatActivity {
    TextView campoidalumno,camponombrealumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_alumno);

        campoidalumno = (TextView) findViewById(R.id.campoidalumno);
        camponombrealumno = (TextView) findViewById(R.id.camponombrealumno);

        Bundle objetoEnviado=getIntent().getExtras();
        Alumno user=null;

        if(objetoEnviado!=null){
            user= (Alumno) objetoEnviado.getSerializable("alumno");
            campoidalumno.setText(user.getIdalumno().toString());
            camponombrealumno.setText(user.getNombrealumno().toString());

        }
    }
}
