package com.example.tp4moviles.ui.salir;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp4moviles.databinding.FragmentSalirBinding;
import com.example.tp4moviles.ui.Dialogo;


public class SalirFragment extends Fragment {

    private  FragmentSalirBinding binding;
    private Dialogo dialogo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SalirViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SalirViewModel.class);

        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        dialogo = new Dialogo();

        binding.btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogo.muestraSalir(getActivity());

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}