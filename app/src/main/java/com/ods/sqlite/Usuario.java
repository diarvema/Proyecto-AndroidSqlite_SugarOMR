package com.ods.sqlite;

import com.orm.SugarRecord;

public class Usuario extends SugarRecord<Usuario> {

    private int cedula;
    private String email;
    private int celular;
    private  String pass;

    public Usuario(){

    }

    public Usuario(int cedula, String email, int celular, String pass) {
        this.cedula = cedula;
        this.email = email;
        this.celular = celular;
        this.pass = pass;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
