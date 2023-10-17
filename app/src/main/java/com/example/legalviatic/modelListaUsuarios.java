package com.example.legalviatic;

public class modelListaUsuarios {
    String correo, documento, nombres, password;
    int saldo, tipoUsuario;

    modelListaUsuarios(){

    }

    public modelListaUsuarios(String correo, String documento, String nombres, String password, int saldo, int tipoUsuario) {
        this.correo = correo;
        this.documento = documento;
        this.nombres = nombres;
        this.password = password;
        this.saldo = saldo;
        this.tipoUsuario = tipoUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
