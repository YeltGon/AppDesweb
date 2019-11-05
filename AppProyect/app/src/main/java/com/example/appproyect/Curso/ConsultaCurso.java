package com.example.appproyect.Curso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appproyect.AdminSQLiteOpenHelper;
import com.example.appproyect.R;
import com.example.appproyect.Utilidades.Utilidades;

public class ConsultaCurso extends AppCompatActivity {

    EditText campoidcurso,camponombrecurso;

    AdminSQLiteOpenHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_curso);

        conn=new AdminSQLiteOpenHelper(getApplicationContext(), "bd_curso", null, 1);

        campoidcurso= (EditText) findViewById(R.id.idcurso);
        camponombrecurso= (EditText) findViewById(R.id.nombrecurso);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnConsultar:
                consultar();
                break;
            case R.id.btnActualizar: actualizarCurso();
                break;
            case R.id.btnEliminar: eliminarCurso();
                break;
        }
    }

    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoidcurso.getText().toString()};
        String[] campos={Utilidades.CAMPO_NOMBRECURSO};

        try {
            Cursor cursor =db.query(Utilidades.TABLA_CURSO,campos,Utilidades.CAMPO_IDCURSO+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            camponombrecurso.setText(cursor.getString(0));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El Curso No Existe",Toast.LENGTH_LONG).show();
            limpiar();
        }

    }


    private void limpiar() {

        camponombrecurso.setText("");
    }

    private void actualizarCurso() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoidcurso.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRECURSO,camponombrecurso.getText().toString());

        db.update(Utilidades.TABLA_CURSO,values,Utilidades.CAMPO_IDCURSO+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Curso Actulizado",Toast.LENGTH_LONG).show();
        db.close();

    }

    private void eliminarCurso() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoidcurso.getText().toString()};

        db.delete(Utilidades.TABLA_CURSO,Utilidades.CAMPO_IDCURSO+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Curso Eliminado",Toast.LENGTH_LONG).show();
        campoidcurso.setText("");
        limpiar();
        db.close();

    }


}
