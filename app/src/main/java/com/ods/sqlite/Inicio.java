package com.ods.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Inicio extends AppCompatActivity {

    EditText txtemailInicio, txtclaveInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        // enlazar variables a los elementos visuales
        txtemailInicio = findViewById(R.id.txtemail);
        txtclaveInicio = findViewById(R.id.txtclave);

    }

    public void Ir_a_Registro(View view) {
        Intent siguiente = new Intent(this, Registro.class);
        startActivity(siguiente);
    }


    public void Login(View view) {

        //obtenemos mail y clave
        String emailinicio = txtemailInicio.getText().toString().trim();
        String claveinicio = txtclaveInicio.getText().toString().trim();

        // validamos Si mail esta vacio
        if (emailinicio.isEmpty()) {
            txtemailInicio.setError("Se debe ingresar un email");
            //Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }


        // validamos Si pass esta vacio
        if (claveinicio.isEmpty()) {
            txtclaveInicio.setError("Se debe ingresar un passwoard");
            //Toast.makeText(this, "Se debe ingresar un passwoard", Toast.LENGTH_LONG).show();
            return;

        }

        // buscar email y pass en bd

        List<Usuario> usuMail = Usuario.find(Usuario.class, "email="+emailinicio,null);
            Usuario Usu = usuMail.get(0);
            String correo = Usu.getEmail();
            String contra = Usu.getPass();


        if (correo.equals(txtemailInicio) && contra.equals(txtclaveInicio)) {
            Toast.makeText(getApplicationContext(),"COINCIDEN",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"NO COINCIDEN",Toast.LENGTH_LONG).show();


        }



    }




}




