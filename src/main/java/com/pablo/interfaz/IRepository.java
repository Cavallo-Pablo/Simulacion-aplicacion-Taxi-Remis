package com.pablo.interfaz;

import com.pablo.clases.Remises;
import com.pablo.excepciones.MiExcepcion;

import java.util.ArrayList;

public interface IRepository<T> {

    // <editor-fold defaultstate="collapsed" desc="Metodos abstractos">
    void agregar(T... objeto); //Alta
    void modificacion(String dato, T nuevo) ; //Modificaciom    public boolean existe(String dato) {

    cargar();
        for (Remises remis : listadoRemises) {
        if (remis.getPatente().equals(dato)) {
            return true;
        }
    }
        return false;
}
    T buscar(String dato) ; //Busqueda
    void eliminar(String dato) ;//Baja
    void mostrar();//Listado
    boolean existe(String dato);//Validacion
    public T asignar();
    void guardar(); //Persistencia
    void cargar() ;//Persistencia
//    </editor-fold>
}
