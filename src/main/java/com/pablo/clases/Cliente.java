package com.pablo.clases;

import java.util.Objects;

public class Cliente {

    // <editor-fold defaultstate="collapsed" desc="Atributos">
String nombre,apellido,telefono,direccion;
//</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">

    public Cliente(String nombre, String apellido, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente() {
    }
//</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

//</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="To String">

    @Override
    public String toString() {
        return "Cliente : " +
                "\nNombre = " + nombre +
                "\nApellido = " + apellido +
                "\nTelefono = " + telefono +
                "\nDireccion = " + direccion +"\n";
    }

//</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos Equals y Hashcode">
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Cliente cliente)) return false;
    return Objects.equals(telefono, cliente.telefono);
}

    @Override
    public int hashCode() {
        int resultado = 17;
        resultado = 31 * resultado + (telefono != null ? telefono.hashCode() : 0);
        return resultado;

    }
//</editor-fold>

}