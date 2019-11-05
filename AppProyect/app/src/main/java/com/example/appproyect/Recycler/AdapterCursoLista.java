package com.example.appproyect.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appproyect.Entidades.Curso;
import com.example.appproyect.R;

import java.util.ArrayList;

public class AdapterCursoLista extends RecyclerView.Adapter<AdapterCursoLista.ViewHolderDatos> {

    ArrayList<Curso> listCurso;

    public AdapterCursoLista(ArrayList<Curso> listaCurso) { this.listCurso = listaCurso;
    }

    @NonNull
    @Override
    public AdapterCursoLista.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutcursos, null, false);
        return new AdapterCursoLista.ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCursoLista.ViewHolderDatos holder, int position) {
        //holder.asignarDatos(listProductos.get(position));
        holder.idcurso.setText(listCurso.get(position).getIdcurso().toString());
        holder.nombrecurso.setText(listCurso.get(position).getNombrecurso().toString());

    }

    @Override
    public int getItemCount() {
        return listCurso.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView idcurso, nombrecurso;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            idcurso=itemView.findViewById(R.id.idDetalle);
            nombrecurso = itemView.findViewById(R.id.nombreDetalle);
        }


    }

}
