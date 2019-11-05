package com.example.appproyect.Curso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appproyect.AdminSQLiteOpenHelper;
import com.example.appproyect.Alumno.DetalleAlumno;
import com.example.appproyect.Alumno.ListViewAlu;
import com.example.appproyect.Entidades.Alumno;
import com.example.appproyect.Entidades.Curso;
import com.example.appproyect.R;
import com.example.appproyect.Utilidades.Utilidades;

import java.util.ArrayList;

public class ListViewCurso extends AppCompatActivity {

    ListView listViewCursos;
    ArrayList<String> listaInformacion;
    ArrayList<Curso> listaCursos;

    AdminSQLiteOpenHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_curso);

        conn=new AdminSQLiteOpenHelper(getApplicationContext(), "bd_curso", null, 1);

        listViewCursos= (ListView) findViewById(R.id.listViewCursos);

        consultarListaCursos();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);


        listViewCursos.setAdapter(adaptador);
        listViewCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                String informacion="idcurso: "+listaCursos.get(pos).getIdcurso()+"\n";
                informacion+="nombrecurso: "+listaCursos.get(pos).getNombrecurso()+"\n";

                Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();

                Curso user=listaCursos.get(pos);

                Intent intent=new Intent(ListViewCurso.this, DetalleCurso.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("curso",user);

                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }

    private void consultarListaCursos() {

        SQLiteDatabase db=conn.getReadableDatabase();

        Curso curso=null;
        listaCursos=new ArrayList<Curso>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_CURSO,null);

        while (cursor.moveToNext()){
            curso=new Curso ();
            curso.setIdcurso(cursor.getInt(0));
            curso.setNombrecurso(cursor.getString(1));

            listaCursos.add(curso);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i=0; i<listaCursos.size();i++){
            listaInformacion.add(listaCursos.get(i).getIdcurso()+" - "
                    +listaCursos.get(i).getNombrecurso());
        }


    }
}

