package com.example.proyectopersonas.fragments;

import android.content.Context;
import android.content.PeriodicSync;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectopersonas.R;
import com.example.proyectopersonas.adaptadores.AdaptadorRecycler;
import com.example.proyectopersonas.utils.Persona;

import java.util.ArrayList;

public class FragmentPersonas extends Fragment {

    private RecyclerView recycler_personas;
    private AdaptadorRecycler adaptador_recycler;
    private View v;
    private ArrayList<Persona> lista_personas;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        lista_personas = new ArrayList<>();
        lista_personas.add(new Persona("Julio", "de Blas", 691155101, R.drawable.images));
        lista_personas.add(new Persona("Julio", "de Blas", 691155101, R.drawable.images2));
        lista_personas.add(new Persona("Julio", "de Blas", 691155101, R.drawable.images3));
        lista_personas.add(new Persona("Julio", "de Blas", 691155101, R.drawable.images4));
        lista_personas.add(new Persona("Julio", "de Blas", 691155101, R.drawable.images5));
        lista_personas.add(new Persona("Julio", "de Blas", 691155101, R.drawable.images6));
        adaptador_recycler = new AdaptadorRecycler(lista_personas, context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.layout_fragment_personas, container, false);
        recycler_personas = v.findViewById(R.id.recycler_personas);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recycler_personas.setAdapter(adaptador_recycler);
        recycler_personas.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
    }
}
