package com.example.appproyect.Alumno;

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
import com.example.appproyect.Entidades.Alumno;
import com.example.appproyect.R;
import com.example.appproyect.Utilidades.Utilidades;

import java.util.ArrayList;

public class ListViewAlu extends AppCompatActivity {
    ListView listViewPersonas;
    ArrayList<String> listaInformacion;
    ArrayList<Alumno> listaUsuarios;

    AdminSQLiteOpenHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_alu);
        conn=new AdminSQLiteOpenHelper(getApplicationContext(), "bd_prueba", null, 1);

        listViewPersonas= (ListView) findViewById(R.id.listViewPersonas);

        consultarListaPersonas();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewPersonas.setAdapter(adaptador);

        listViewPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                String informacion="idalumno: "+listaUsuarios.get(pos).getIdalumno()+"\n";
                informacion+="nombrealumno: "+listaUsuarios.get(pos).getNombrealumno()+"\n";

                Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();

                Alumno user=listaUsuarios.get(pos);

                Intent intent=new Intent(ListViewAlu.this,DetalleAlumno.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("alumno",user);

                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

    private void consultarListaPersonas() {

        SQLiteDatabase db=conn.getReadableDatabase();

        Alumno alumno=null;
        listaUsuarios=new ArrayList<Alumno>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_ALUMNO,null);

        while (cursor.moveToNext()){
            alumno=new Alumno();
            alumno.setIdalumno(cursor.getInt(0));
            alumno.setNombrealumno(cursor.getString(1));

            listaUsuarios.add(alumno);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i=0; i<listaUsuarios.size();i++){
            listaInformacion.add(listaUsuarios.get(i).getIdalumno()+" - "
                    +listaUsuarios.get(i).getNombrealumno());
        }


    }

}
