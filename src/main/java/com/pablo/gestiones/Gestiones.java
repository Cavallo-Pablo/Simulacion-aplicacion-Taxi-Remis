package com.pablo.gestiones;

import com.pablo.clases.Cliente;
import com.pablo.clases.Remises;
import com.pablo.clases.Taxis;
import com.pablo.enumeradores.Estados;
import com.pablo.excepciones.MiExcepcion;
import com.pablo.repositorio.ClienteRepo;
import com.pablo.repositorio.RemisRepo;
import com.pablo.repositorio.TaxiRepo;
//import android.media.ToneGenerator;
//import android.media.AudioManager;

//import javax.sound.sampled.*;
//import java.applet.AudioClip;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestiones {

    // <editor-fold defaultstate="collapsed" desc="Atributos">
    ClienteRepo clientes = new ClienteRepo();
    RemisRepo remises = new RemisRepo();
    TaxiRepo taxis = new TaxiRepo();
    Remises remis = new Remises();
    Cliente cliente = new Cliente();
    Taxis taxi = new Taxis();
    Scanner scan = new Scanner(System.in);
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Gestion de Clientes">
    public void agregarCliente() {

        //     Cliente c1 = new Cliente("Pepe", "Argento", "1178963214", "Calle ausente 789");
        //    Cliente c2 = new Cliente("Juana", "Molina", "1114789632", "Calle ausente 321");
        //   clientes.agregar(c1, c2);
        System.out.println("Ingresar un Nombre : ");
        String nombre = scan.nextLine();
        System.out.println("Ingresar un Apellido : ");
        String apellido = scan.nextLine();
//        System.out.println("Ingresar un Telegono : ");
//        String telefono = scan.nextLine();
//        System.out.println("Ingresar una Direccion : ");
//        String direccion = scan.nextLine();
//        Cliente c3 = new Cliente(nombre, apellido, telefono, direccion);
//        clientes.agregar(c3);
        String aux;
        do {
            System.out.println("Ingresar un Telegono : ");
            aux = scan.nextLine();
            try {
                if (clientes.existe(aux)) {
                    throw new MiExcepcion("El aux esta repetido");
                }
            } catch (MiExcepcion e) {
                System.out.println(e.getMessage());
            }
        } while (clientes.existe(aux));
        String telefono = aux;
        System.out.println("Ingresar una Direccion : ");
        String direccion = scan.nextLine();
        Cliente c3 = new Cliente(nombre, apellido, telefono, direccion);
        clientes.agregar(c3);

    }

    public void modificacionCliente() throws MiExcepcion {
        System.out.println("Ingresar Telegono para buscar: ");
        String buscado = scan.nextLine();
        Cliente modificar = new Cliente();
        System.out.println("Ingresar nuevo Nombre : ");
        modificar.setNombre(scan.nextLine());
        System.out.println("Ingresar nuevo Apellido : ");
        modificar.setApellido(scan.nextLine());
        String aux;
        do {
            System.out.println("Ingresar nuevo Telegono : ");
            aux = scan.nextLine();
            try {
                if (clientes.existe(aux)) {
                    throw new MiExcepcion("El telefono esta repetido");
                }
            } catch (MiExcepcion e) {
                System.out.println(e.getMessage());
            }
        } while (clientes.existe(aux));
        modificar.setTelefono(aux);
        System.out.println("Ingresar nueva Direccion : ");
        modificar.setDireccion(scan.nextLine());
        clientes.modificacion(buscado, modificar);
    }

    public void buscarCliente() throws MiExcepcion {
        System.out.println("Ingrese el Telefono del cliente a buscar : ");
        String dato = scan.nextLine();
        Cliente buscado = new Cliente();
        buscado = clientes.buscar(dato);
        System.out.println("\nCliente encontrado : \n\n" + buscado);
    }

    public void eliminarCliente() {
        System.out.println("Ingrese el Telefono del cliente a eliminar");
        String dato = scan.nextLine();
        clientes.eliminar(dato);
    }

    public void mostrarClientes() {
        clientes.mostrar();
    }

    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Gestion de Remises">
    public void agregarRemises() {

        System.out.println("Ingresar un Marca : ");
        String marca = scan.nextLine();
        System.out.println("Ingresar un Modelo : ");
        String modelo = scan.nextLine();
        System.out.println("Ingresar una Tipo de combustible : ");
        String tipoDeCombustible = scan.nextLine();

        String aux;
        do {
            System.out.println("Ingresar un Patente : ");
            aux = scan.nextLine();
            try {
                if (remises.existe(aux)) {
                    throw new MiExcepcion("La patente esta repetida");
                }
            } catch (MiExcepcion e) {
                System.out.println(e.getMessage());
            }
        } while (remises.existe(aux));
        String patente = aux;
        System.out.println("Ingresar una Tarifa por cuadra : ");
        int tarifaPorCuadra = scan.nextInt();
        Remises remis = new Remises(marca, modelo, tipoDeCombustible, patente, tarifaPorCuadra);
        remises.agregar(remis);

    }

    public void modificacionRemises() throws MiExcepcion {
        System.out.println("Ingresar Patente para buscar: ");
        String buscado = scan.nextLine();
        Remises modificar = new Remises();
        System.out.println("Ingresar nueva Marca : ");
        modificar.setMarca(scan.nextLine());
        System.out.println("Ingresar nuevo Modelo : ");
        modificar.setModelo(scan.nextLine());
        System.out.println("Ingresar nuevo Tipo de combustible : ");
        modificar.setTipoCombustible(scan.nextLine());
        String aux;
        do {
            System.out.println("Ingresar nueva Patente : ");
            aux = scan.nextLine();
            try {
                if (remises.existe(aux)) {
                    throw new MiExcepcion("La Patente esta repetida");
                }
            } catch (MiExcepcion e) {
                System.out.println(e.getMessage());
            }
        } while (remises.existe(aux));
        modificar.setPatente(aux);
        System.out.println("Ingresar nueva Tarifa por cuadra : ");
        modificar.setTarifaCuadra(scan.nextInt());
        remises.modificacion(buscado, modificar);
    }

    public void buscarRemises() throws MiExcepcion {
        System.out.println("Ingrese la Patente del remis a buscar : ");
        String dato = scan.nextLine();
        Remises buscado = new Remises();
        buscado = remises.buscar(dato);
        System.out.println("\nRemises encontrado : \n\n" + buscado);
    }

    public void eliminarRemises() {
        System.out.println("Ingrese la Patente del remis a eliminar");
        String dato = scan.nextLine();
        remises.eliminar(dato);
    }

    public void mostrarRemises() {
        remises.mostrar();
    }

    public void pedirUnRemis() {
        cliente = clientes.asignar();
        System.out.println("\nHola " + cliente.getNombre() + " en que lo puedo ayudar ?");
        remis = remises.asignar();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nHola...! Necesito un remis, por favor ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nIngrese la distancia a recorrer : ");
        int distancia = scan.nextInt();
        System.out.println("En breve de le asignara un vehiculo");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Movil Marca : " + remis.getMarca() + " - Modelo : " + remis.getModelo() + " - Patente : " + remis.getPatente());
        remis.setEstado(Estados.OCUPADO);
        System.out.println("\nMovil en estado " + remis.getEstado());
        int precio = distancia * remis.getTarifaCuadra();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("====================================");
        System.out.println("Su Ticket "+cliente.getNombre());
        System.out.println("====================================");
        System.out.println("La distancia recorrida es : " + distancia + " Kmts.");
        System.out.println("Precio por cuadra : $ " + remis.getTarifaCuadra());
        System.out.println("Abonara un total de : $ " + precio);
        System.out.println("====================================\n");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Gracias por elegirnos");
        remis.setEstado(Estados.LIBRE);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nMovil : \n" + remis.getEstado() + " para su proximo viaje\b\n");

    }
//</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Gestion de Taxis">
    public void agregarTaxis() {

        System.out.println("Ingresar un Marca : ");
        String marca = scan.nextLine();
        System.out.println("Ingresar un Modelo : ");
        String modelo = scan.nextLine();
        System.out.println("Ingresar una Tipo de combustible : ");
        String tipoDeCombustible = scan.nextLine();

        String aux;
        do {
            System.out.println("Ingresar un Patente : ");
            aux = scan.nextLine();
            try {
                if (taxis.existe(aux)) {
                    throw new MiExcepcion("La patente esta repetida");
                }
            } catch (MiExcepcion e) {
                System.out.println(e.getMessage());
            }
        } while (taxis.existe(aux));
        String patente = aux;
        System.out.println("Ingresar una bajada de bandera : ");
        int bajadaBandera = scan.nextInt();
        System.out.println("Ingresar una Precio por kilometro : ");
        int precioKilometro = scan.nextInt();
        Taxis remis = new Taxis(marca, modelo, tipoDeCombustible, patente, bajadaBandera, precioKilometro);
        taxis.agregar(remis);

    }

    public void modificacionTaxis() throws MiExcepcion {
        System.out.println("Ingresar Patente para buscar: ");
        String buscado = scan.nextLine();
        Taxis modificar = new Taxis();
        System.out.println("Ingresar nueva Marca : ");
        modificar.setMarca(scan.nextLine());
        System.out.println("Ingresar nuevo Modelo : ");
        modificar.setModelo(scan.nextLine());
        System.out.println("Ingresar nuevo Tipo de combustible : ");
        modificar.setTipoCombustible(scan.nextLine());
        String aux;
        do {
            System.out.println("Ingresar nueva Patente : ");
            aux = scan.nextLine();
            try {
                if (taxis.existe(aux)) {
                    throw new MiExcepcion("La Patente esta repetida");
                }
            } catch (MiExcepcion e) {
                System.out.println(e.getMessage());
            }
        } while (taxis.existe(aux));
        modificar.setPatente(aux);
        System.out.println("Ingresar una bajada de bandera : ");
        modificar.setBajadaBandera(scan.nextInt());
        System.out.println("Ingresar una Precio por kilometro : ");
        modificar.setPrecioKilometro(scan.nextInt());
        taxis.modificacion(buscado, modificar);
    }

    public void buscarTaxis() throws MiExcepcion {
        System.out.println("Ingrese la Patente del taxi a buscar : ");
        String dato = scan.nextLine();
        Taxis buscado = new Taxis();
        buscado = taxis.buscar(dato);
        System.out.println("\nTaxis encontrado : \n\n" + buscado);
    }

    public void eliminarTaxis() {
        System.out.println("Ingrese la Patente del taxi a eliminar");
        String dato = scan.nextLine();
        taxis.eliminar(dato);
    }

    public void mostrarTaxiss() {
        taxis.mostrar();
    }

    public void pedirUnTaxi() {
        cliente = clientes.asignar();
        System.out.println("\nHola " + cliente.getNombre()+" en que lo puedo ayudar ?");
        taxi = taxis.asignar();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nHola...! Necesito un taxi, por favor ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nIngrese la distancia a recorrer : ");
        int distancia = scan.nextInt();
        System.out.println("En breve de le asignara un vehiculo");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Movil Marca : " + taxi.getMarca() + " - Modelo : " + taxi.getModelo() + " - Patente : " + taxi.getPatente());
        taxi.setEstado(Estados.OCUPADO);
        System.out.println("\nMovil en estado " + taxi.getEstado());
        int precio = distancia * taxi.getPrecioKilometro() + taxi.getBajadaBandera();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("====================================");
        System.out.println("Su Ticket "+cliente.getNombre());
        System.out.println("====================================");
        System.out.println("La distancia recorrida es : " + distancia + " Kmts.");
        System.out.println("Bajada de bandera : $ " + taxi.getBajadaBandera());
        System.out.println("Precio por kilometro : $ " + taxi.getPrecioKilometro());
        System.out.println("Abonara un total de : $ " + precio);
        System.out.println("====================================\n");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Gracias por elegirnos");
        taxi.setEstado(Estados.LIBRE);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nMovil : \n" + taxi.getEstado() + " para su proximo viaje\b\n");

    }
    //</editor-fold>

}
