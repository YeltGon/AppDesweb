package com.example.appproyect.Curso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appproyect.Entidades.Alumno;
import com.example.appproyect.Entidades.Curso;
import com.example.appproyect.R;

public class DetalleCurso extends AppCompatActivity {
    TextView campoidcurso,camponombrecurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_curso);

        campoidcurso = (TextView) findViewById(R.id.campoidcurso);
        camponombrecurso = (TextView) findViewById(R.id.camponombrecurso);

        Bundle objetoEnviado=getIntent().getExtras();
        Curso user=null;

        if(objetoEnviado!=null){
            user= (Curso) objetoEnviado.getSerializable("curso");
            campoidcurso.setText(user.getIdcurso().toString());
            camponombrecurso.setText(user.getNombrecurso().toString());

        }
    }
}
