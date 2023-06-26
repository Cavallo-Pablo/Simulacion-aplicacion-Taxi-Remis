package com.pablo.clases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pablo.enumeradores.Estados;

public class Taxis extends Vehiculo {

    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private int bajadaBandera, precioKilometro;
    @JsonIgnore
    private Estados estado;
//    </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Taxis(String marca, String modelo, String tipoCombustible, String patente, int bajadaBandera, int precioKilometro) {
        super(marca, modelo, tipoCombustible, patente);
        this.bajadaBandera = bajadaBandera;
        this.precioKilometro = precioKilometro;
    }

    public Taxis(int bajadaBandera, int precioKilometro) {
        this.bajadaBandera = bajadaBandera;
        this.precioKilometro = precioKilometro;
    }

    public Taxis(Estados estado) {
        this.estado = estado;
    }

    public Taxis() {
    }



//    </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public int getBajadaBandera() {
        return bajadaBandera;
    }

    public void setBajadaBandera(int bajadaBandera) {
        this.bajadaBandera = bajadaBandera;
    }

    public int getPrecioKilometro() {
        return precioKilometro;
    }

    public void setPrecioKilometro(int precioKilometro) {
        this.precioKilometro = precioKilometro;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }


//    </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="To String">

    @Override
    public String toString() {
        return "Taxi " + "\nEstado = " + estado +super.toString() +
                "\nBajada de Bandera = $ " + bajadaBandera +
                "\nPrecio por Kilometro = $ " + precioKilometro + "\n";
    }

//    </editor-fold>

}