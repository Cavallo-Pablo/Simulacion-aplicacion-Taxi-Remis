package com.pablo.clases;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public abstract class Vehiculo {

    // <editor-fold defaultstate="collapsed" desc="Atributos">
   protected String marca, modelo, tipoCombustible, patente;

    public enum estado {
   LIBRE,EN_USO
    }

    @JsonIgnore
    private estado estados;
//    </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public Vehiculo(String marca, String modelo, String tipoCombustible, String patente) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.patente = patente;
    }

    public Vehiculo() {
    }
//    </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
//    </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="toString">
    @Override
    public String toString() {
        return "\nMarca = " + marca +
                "\nModelo = " + modelo +
                "\nTipoCombustible = " + tipoCombustible +
                "\nPatente = " + patente;
    }
    //    </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos Equals y Hashcode">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo vehiculo)) return false;
        return Objects.equals(patente, vehiculo.patente);
    }

    @Override
    public int hashCode() {
        int resultado = 17;
        resultado = 31 * resultado + (patente != null ? patente.hashCode() : 0);
        return resultado;

    }
//</editor-fold>

}
