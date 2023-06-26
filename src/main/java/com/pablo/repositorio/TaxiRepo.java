package com.pablo.repositorio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pablo.clases.Cliente;
import com.pablo.clases.Remises;
import com.pablo.clases.Taxis;
import com.pablo.interfaz.IRepository;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaxiRepo implements IRepository<Taxis>, Serializable {

    // <editor-fold defaultstate="collapsed" desc="Atributos">
String ruta = "src\\main\\java\\com\\pablo\\archivos\\taxis.json";
    ObjectMapper mapeo = new ObjectMapper();
    private final File archivo = new File(ruta);
    ArrayList<Taxis> listadoTaxis = new ArrayList<>();
//</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    public void agregar(Taxis... objeto) {
        cargar();
        listadoTaxis.addAll(List.of(objeto));
        guardar();
    }

    @Override
    public void modificacion(String dato, Taxis nuevo) {
        cargar();
        try {
            for (Taxis taxi : listadoTaxis) {
                if (taxi.getPatente().equals(dato)) {
                    taxi.setMarca(nuevo.getMarca());
                    taxi.setModelo(nuevo.getModelo());
                    taxi.setTipoCombustible(nuevo.getTipoCombustible());
                    taxi.setPatente(nuevo.getPatente());
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        guardar();
    }

    @Override
    public Taxis buscar(String dato) {
        cargar();
        Taxis aux = null;
        try {
            for (Taxis taxi : listadoTaxis) {
                if (taxi.getPatente().equals(dato)) {
                    aux = taxi;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return aux;
    }

    @Override
    public void eliminar(String dato) {
        cargar();
        Taxis aux = null;
        try {
            for (Taxis taxi : listadoTaxis) {
                if (taxi.getPatente().equals(dato)) {
                    aux = taxi;
                    break;
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        listadoTaxis.remove(aux);
        guardar();
    }

    @Override
    public void mostrar() {
        cargar();
        for (Taxis taxi : listadoTaxis) {
            System.out.println(taxi);
        }
    }

    @Override
    public boolean existe(String dato) {
        for (Taxis taxi : listadoTaxis) {
            if (taxi.getPatente().equals(dato)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Taxis asignar() {
        cargar();
        Taxis taxi = new Taxis();
        Random random = new Random();
        int indiceAleatorio = random.nextInt(listadoTaxis.size());
        taxi = listadoTaxis.get(indiceAleatorio);
        return taxi;
    }

    @Override
    public void guardar() {
        try {
            mapeo.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listadoTaxis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cargar() {
        try {
            listadoTaxis = mapeo.readValue(archivo, new TypeReference<ArrayList<Taxis>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


//</editor-fold>

}
