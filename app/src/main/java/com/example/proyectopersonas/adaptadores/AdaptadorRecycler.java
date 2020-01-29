package com.example.proyectopersonas.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectopersonas.R;
import com.example.proyectopersonas.utils.Persona;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder> {

    OnRecyclerListener listener;
    ArrayList<Persona> lista_personas;
    Context context;

    public AdaptadorRecycler(ArrayList<Persona> lista_personas, Context context) {
        this.lista_personas = lista_personas;
        this.context = context;
        try {
            listener = (OnRecyclerListener) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item_recycler, parent, false);

        return new MiHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
        final Persona persona = lista_personas.get(position);
        holder.getImagen().setImageResource(persona.getImagen());
        holder.getBoton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPersonaSelected(persona);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista_personas.size();
    }

    public interface OnRecyclerListener {
        void onPersonaSelected(Persona persona);
    }

    class MiHolder extends RecyclerView.ViewHolder {

        ImageView imagen;
        Button boton;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_item);
            boton = itemView.findViewById(R.id.boton_item);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public Button getBoton() {
            return boton;
        }
    }
}
