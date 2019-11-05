package com.example.appproyect;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appproyect.Utilidades.Utilidades;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BasedeDatos) {

        BasedeDatos.execSQL(Utilidades.CREAR_TABLA_ALUMNO);
        BasedeDatos.execSQL(Utilidades.CREAR_TABLA_GRADO);
        BasedeDatos.execSQL(Utilidades.CREAR_TABLA_CURSO);
        BasedeDatos.execSQL(Utilidades.CREAR_TABLA_ASIGNACION);


    }

    @Override
    public void onUpgrade(SQLiteDatabase BasedeDatos, int oldVersion, int newVersion) {
        BasedeDatos.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ALUMNO);
        BasedeDatos.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_GRADO);
        BasedeDatos.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CURSO);
        BasedeDatos.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_ASIGNACION);

        onCreate(BasedeDatos);
    }
}
