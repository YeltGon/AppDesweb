package com.example.appproyect.Alumno;

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

public class ConsultaAlumno extends AppCompatActivity {
    EditText campoidalumno,camponombrealumno;

    AdminSQLiteOpenHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_alumno);

        conn=new AdminSQLiteOpenHelper(getApplicationContext(), "bd_prueba", null, 1);

        campoidalumno= (EditText) findViewById(R.id.idalumno);
        camponombrealumno= (EditText) findViewById(R.id.nombrealumno);
    }



    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnConsultar:
                consultar();
                break;
            case R.id.btnActualizar: actualizarUsuario();
                break;
            case R.id.btnEliminar: eliminarUsuario();
                break;
        }
    }



    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoidalumno.getText().toString()};
        String[] campos={Utilidades.CAMPO_NOMBRE};

        try {
            Cursor cursor =db.query(Utilidades.TABLA_ALUMNO,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            camponombrealumno.setText(cursor.getString(0));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El Alumno No Existe",Toast.LENGTH_LONG).show();
            limpiar();
        }

    }

    private void limpiar() {

        camponombrealumno.setText("");
    }

    private void actualizarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoidalumno.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,camponombrealumno.getText().toString());

        db.update(Utilidades.TABLA_ALUMNO,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Alumno Actualizado",Toast.LENGTH_LONG).show();
        db.close();

    }

    private void eliminarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoidalumno.getText().toString()};

        db.delete(Utilidades.TABLA_ALUMNO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Usuario Eliminado",Toast.LENGTH_LONG).show();
        campoidalumno.setText("");
        limpiar();
        db.close();

    }

}
