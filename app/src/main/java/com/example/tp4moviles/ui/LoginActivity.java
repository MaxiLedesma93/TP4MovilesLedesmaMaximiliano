package com.example.tp4moviles.ui;

import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.READ_CALL_LOG;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp4moviles.R;
import com.example.tp4moviles.databinding.LoginActivityBinding;

public class LoginActivity extends AppCompatActivity {
    private LoginActivityBinding lBinding;
    private ViewModelLoginActivity vmLogin;
    private Llamada llamada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lBinding = LoginActivityBinding.inflate(getLayoutInflater());
        setContentView(lBinding.getRoot());
        solicitarPersmisos();
        registrarBroadcast();
        vmLogin = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
                .create(ViewModelLoginActivity.class);
        vmLogin.getUsuarioIncorrecto().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                lBinding.tvIncorrecto.setText("Usuario Incorrecto");

            }
        });
        lBinding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vmLogin.validarUsuario(lBinding.etUsuario.getText().toString(),
                        lBinding.etContraseA.getText().toString());
            }
        });

    }
    private void registrarBroadcast(){
        this.llamada = new Llamada();
        registerReceiver(llamada,new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));
    }
    private void solicitarPersmisos(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M
                && checkSelfPermission(CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{CALL_PHONE},1000);
        }
    }

}