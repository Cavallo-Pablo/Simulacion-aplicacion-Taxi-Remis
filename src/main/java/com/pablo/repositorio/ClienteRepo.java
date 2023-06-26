package com.pablo.repositorio;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pablo.clases.Cliente;
import com.pablo.clases.Taxis;
import com.pablo.excepciones.MiExcepcion;
import com.pablo.interfaz.IRepository;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClienteRepo implements IRepository<Cliente>, Serializable {

    // <editor-fold defaultstate="collapsed" desc="Atributos">
String ruta = "src\\main\\java\\com\\pablo\\archivos\\clientes.json";
    ObjectMapper mapeo = new ObjectMapper();
    private final File archivo = new File(ruta);
    ArrayList<Cliente> listadoClientes = new ArrayList<>();
//</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    public void agregar(Cliente... objeto) {
        cargar();
        listadoClientes.addAll(List.of(objeto));
        guardar();
    }
    @Override
    public void modificacion(String dato, Cliente nuevo){
        cargar();
        try {
            for (Cliente cliente : listadoClientes) {
                if (cliente.getTelefono().equals(dato)) {
                    cliente.setNombre(nuevo.getNombre());
                    cliente.setApellido(nuevo.getApellido());
                    cliente.setTelefono(nuevo.getTelefono());
                    cliente.setDireccion(nuevo.getDireccion());
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        guardar();
    }
    @Override
    public Cliente buscar(String dato){
        cargar();
        Cliente aux = null;
        try {
            for (Cliente c : listadoClientes) {
                if (c.getTelefono().equals(dato)) {
                    aux = c;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return aux;
    }
    @Override
    public void eliminar(String dato){
        cargar();
        Cliente aux = null;
        try {
            for (Cliente c : listadoClientes) {
                if (c.getTelefono().equals(dato)) {
                    aux = c;
                    break;
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        listadoClientes.remove(aux);
        guardar();
    }
    @Override
    public void mostrar() {
        cargar();
        for (Cliente c : listadoClientes) {
            System.out.println(c);
        }
    }
    @Override
    public boolean existe(String dato) {
        cargar();
        for (Cliente c : listadoClientes) {
            if (c.getTelefono().equals(dato)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Cliente asignar() {
        cargar();
        Cliente cliente = new Cliente();
        Random random = new Random();
        int indiceAleatorio = random.nextInt(listadoClientes.size());
        cliente = listadoClientes.get(indiceAleatorio);
        return cliente;
    }

    @Override
    public void guardar() {
        try {
            mapeo.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listadoClientes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void cargar() {
        try {
            listadoClientes = mapeo.readValue(archivo, new TypeReference<ArrayList<Cliente>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//</editor-fold>

}