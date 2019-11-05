package com.example.appproyect.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appproyect.Entidades.Alumno;
import com.example.appproyect.R;

import java.util.ArrayList;

public class AdapterAlumnoLista extends RecyclerView.Adapter<AdapterAlumnoLista.ViewHolderDatos>{


    ArrayList<Alumno> listAlumno;

    public AdapterAlumnoLista(ArrayList<Alumno> listaAlumno) { this.listAlumno = listaAlumno;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutalumnos, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        //holder.asignarDatos(listProductos.get(position));
        holder.id.setText(listAlumno.get(position).getIdalumno().toString());
        holder.nombre.setText(listAlumno.get(position).getNombrealumno().toString());

    }

    @Override
    public int getItemCount() {
        return listAlumno.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView id, nombre, telefono;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.idDetalle);
            nombre = itemView.findViewById(R.id.nombreDetalle);
        }


    }
}
