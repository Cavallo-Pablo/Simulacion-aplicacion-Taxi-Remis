package com.pablo.clases;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pablo.enumeradores.Estados;

public class Remises extends Vehiculo {

    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private int tarifaCuadra;
    @JsonIgnore
    private Estados estado;
//    </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructores">
    public Remises(String marca, String modelo, String tipoCombustible, String patente, int tarifaCuadra) {
        super(marca, modelo, tipoCombustible, patente);
        this.tarifaCuadra = tarifaCuadra;
    }

    public Remises(int tarifaCuadra) {
        this.tarifaCuadra = tarifaCuadra;
    }

    public Remises(Estados estado) {
        this.estado = estado;
    }

    public Remises() {
    }
//    </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public int getTarifaCuadra() {
        return tarifaCuadra;
    }

    public void setTarifaCuadra(int tarifaCuadra) {
        this.tarifaCuadra = tarifaCuadra;
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
        return "Remis " +"\nEstado=" + estado + super.toString() +
                "\nTarifa por Cuadra=" + tarifaCuadra
                ;

    }
//    </editor-fold>

}