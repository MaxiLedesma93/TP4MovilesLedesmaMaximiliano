package com.example.tp4moviles.ui.llamada;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LlamadaViewModel extends AndroidViewModel {

    public LlamadaViewModel(@NonNull Application application) {
        super(application);
    }



    public void realizarLlamada(Intent intent){
        Intent intentLlamada = new Intent(Intent.ACTION_CALL);
        intentLlamada.setData(Uri.parse(intent.getStringExtra("numero")));
        intentLlamada.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(intentLlamada);


    }

}