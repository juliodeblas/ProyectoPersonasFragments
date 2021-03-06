package com.example.proyectopersonas.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.proyectopersonas.R;
import com.example.proyectopersonas.utils.Persona;

public class FragmentDetalle extends Fragment {

    private Persona persona;

    public static FragmentDetalle newInstance(Persona persona){
        FragmentDetalle fragmentDetalle = new FragmentDetalle();
        Bundle bundle = new Bundle();
        bundle.putSerializable("persona", persona);
        fragmentDetalle.setArguments(bundle);

        return fragmentDetalle;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        persona = (Persona) this.getArguments().get("persona");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragment_detalle, container, false);

        return v;
    }
}
