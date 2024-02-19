package com.core.arnuv.enums;

public enum EnumEstadoSession {
    INGRESADO("I", "LOGIN CON EXITO"),
    FALLIDO("F", "INTENTO FALLIDO DE LOGIN"),
    SALIR("L", "LOGOUT DEL SISTEMA"),
    SALIDAAUTOMATICA("S", "EL SISTEMA REALIZO LOGOUT POR INACTIVIDAD");

    String codigo;
    String nombre;
    private EnumEstadoSession(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
