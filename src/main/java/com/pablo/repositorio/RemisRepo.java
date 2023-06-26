package com.pablo.repositorio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pablo.clases.Cliente;
import com.pablo.clases.Remises;
import com.pablo.clases.Taxis;
import com.pablo.enumeradores.Estados;
import com.pablo.interfaz.IRepository;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RemisRepo implements IRepository<Remises>, Serializable {

    // <editor-fold defaultstate="collapsed" desc="Atributos">
    String ruta = "src\\main\\java\\com\\pablo\\archivos\\remises.json";
    ObjectMapper mapeo = new ObjectMapper();
    private final File archivo = new File(ruta);
    ArrayList<Remises> listadoRemises = new ArrayList<>();
    Remises remis = new Remises();
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    public void agregar(Remises... objeto) {
        cargar();
        listadoRemises.addAll(List.of(objeto));
        guardar();
    }

    @Override
    public void modificacion(String dato, Remises nuevo) {
        cargar();
        try {
            for (Remises remis : listadoRemises) {
                if (remis.getPatente().equals(dato)) {
                    remis.setMarca(nuevo.getMarca());
                    remis.setModelo(nuevo.getModelo());
                    remis.setTipoCombustible(nuevo.getTipoCombustible());
                    remis.setPatente(nuevo.getPatente());
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        guardar();
    }

    @Override
    public Remises buscar(String dato) {
        cargar();
        Remises aux = null;
        try {
            for (Remises remis : listadoRemises) {
                if (remis.getPatente().equals(dato)) {
                    aux = remis;
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
        Remises aux = null;
        try {
            for (Remises remis : listadoRemises) {
                if (remis.getPatente().equals(dato)) {
                    aux = remis;
                    break;
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        listadoRemises.remove(aux);
        guardar();
    }

    @Override
    public void mostrar() {
        cargar();
        for (Remises remis : listadoRemises) {
            System.out.println(remis);
        }
    }

    @Override
    public boolean existe(String dato) {

        cargar();
        for (Remises remis : listadoRemises) {
            if (remis.getPatente().equals(dato)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void guardar() {
        try {
            mapeo.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listadoRemises);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cargar() {
        try {
            listadoRemises = mapeo.readValue(archivo, new TypeReference<ArrayList<Remises>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Remises asignar() {
        cargar();
        Remises remis = new Remises();
        Random random = new Random();
        int indiceAleatorio = random.nextInt(listadoRemises.size());
        remis = listadoRemises.get(indiceAleatorio);
        return remis;
    }
//</editor-fold>

}
