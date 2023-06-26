package com.pablo.excepciones;
public class MiExcepcion extends Throwable {
    public MiExcepcion (String mensaje){
        super(mensaje);
    }
}