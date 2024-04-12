package com.example.tp4moviles.ui;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp4moviles.MenuActivity;
import com.example.tp4moviles.entidades.Usuario;

public class ViewModelLoginActivity extends AndroidViewModel {
    private Usuario usuario;
    private MutableLiveData<Boolean> usuarioIncorrecto;
    public ViewModelLoginActivity(@NonNull Application application) {
        super(application);
        usuario = new Usuario("Maximiliano", "123456");
    }

    public LiveData<Boolean> getUsuarioIncorrecto(){
        if(usuarioIncorrecto==null){
            usuarioIncorrecto = new MutableLiveData<>();
        }
        return usuarioIncorrecto;
    }



    public void validarUsuario(String nombre, String password){

        if (nombre.equals(usuario.getName())&&password.equals(usuario.getPassword())){
            Intent intent = new Intent(getApplication(), MenuActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplication().startActivity(intent);

        }else {
            usuarioIncorrecto.setValue(false);

        }
    }
}