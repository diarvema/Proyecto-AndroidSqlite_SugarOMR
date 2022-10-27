package com.ods.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.WeakHashMap;

public class Registro extends AppCompatActivity {

    // Variables
    EditText cedula, email, celular, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

    // enlazar variables a los elementos visuales
        cedula = findViewById(R.id.txt_cedula);
        email = findViewById(R.id.txt_emailRegistro);
        celular = findViewById(R.id.txt_celular);
        pass = findViewById(R.id.txt_passRegistro);

    }
    // Metodo Guardar
    public void Guardar(View view){
        int doc = Integer.parseInt(cedula.getText().toString().trim());
        String mail = email.getText().toString().trim();
        int celu = Integer.parseInt(celular.getText().toString().trim());
        String passw = pass.getText().toString();

        Usuario user = new Usuario(doc,mail,celu,passw);
        user.save();

        cedula.setText("");
        email.setText("");
        celular.setText("");
        pass.setText("");

        Toast.makeText(getApplicationContext(),"Usuario guardado con éxito",Toast.LENGTH_LONG).show();


    }

    //Información de registro
    public void VerificacionLogin(){



    }


    // Metodo Consultar
    public void Consultar(View view){

        int doc = Integer.parseInt(cedula.getText().toString());

        List<Usuario> usu = Usuario.find(Usuario.class, "cedula="+doc,null);
        if (usu.size()<=0){
            Toast.makeText(getApplicationContext(),"Usuario no existe",Toast.LENGTH_LONG).show();
        }else {

            Usuario user = usu.get(0);
            email.setText(user.getEmail());
            celular.setText("" + user.getCelular());
            pass.setText(user.getPass());
        }

    }

    // Metodo Actualizar
    public void Editar(View view){
        int doc = Integer.parseInt(cedula.getText().toString());

        List<Usuario> usu = Usuario.find(Usuario.class, "cedula="+doc,null);

        if (usu.size()<=0){
            Toast.makeText(getApplicationContext(),"Usuario no existe",Toast.LENGTH_LONG).show();
        }else {
            Usuario user = usu.get(0);
            user.setEmail(email.getText().toString());
            user.setCelular(Integer.parseInt( celular.getText().toString()));
            user.setPass(pass.getText().toString());
            user.save();

            cedula.setText("");
            email.setText("");
            celular.setText("");
            pass.setText("");

            Toast.makeText(getApplicationContext(),"Usuario actualizado",Toast.LENGTH_LONG).show();

        }

    }

    // Metodo Eliminar
    public void Eliminar(View view){
        int doc = Integer.parseInt(cedula.getText().toString());

        List<Usuario> usu = Usuario.find(Usuario.class, "cedula="+doc,null);

        if (usu.size()<=0){
            Toast.makeText(getApplicationContext(),"Usuario no existe",Toast.LENGTH_LONG).show();
        }else {
            Usuario user = usu.get(0);
            user.delete();

            cedula.setText("");
            email.setText("");
            celular.setText("");
            pass.setText("");

            Toast.makeText(getApplicationContext(),"Usuario eliminado",Toast.LENGTH_LONG).show();
        }
    }


}