package com.example.tp4moviles.ui.llamada;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp4moviles.databinding.FragmentLlamadaBinding;
public class LlamadaFragment extends Fragment {

    private FragmentLlamadaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LlamadaViewModel llamadaViewModel =
                new ViewModelProvider(this).get(LlamadaViewModel.class);

        binding = FragmentLlamadaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), llamadaViewModel.getClass());
                intent.putExtra("numero", "tel:"+binding.etNumero.getText().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                llamadaViewModel.realizarLlamada(intent);
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