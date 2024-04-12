package com.example.tp4moviles.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.fragment.app.FragmentActivity;

public class Dialogo{

    public void muestraSalir(FragmentActivity fragmentActivity){
        AlertDialog.Builder builder = new AlertDialog.Builder(fragmentActivity);
        builder.setTitle("Desea Salir?");
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                fragmentActivity.finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                fragmentActivity.getSupportFragmentManager().popBackStack();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}
