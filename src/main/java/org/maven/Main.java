package org.maven;

import com.pablo.clases.Remises;
import com.pablo.clases.Taxis;
import com.pablo.excepciones.MiExcepcion;
import com.pablo.gestiones.Gestiones;
import com.pablo.repositorio.RemisRepo;
import com.pablo.repositorio.TaxiRepo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MiExcepcion {

        menuPrincipal();

    }

    // <editor-fold defaultstate="collapsed" desc="Switch Menues">
    public static void menuPrincipal() throws MiExcepcion {
        RemisRepo remisRepo = new RemisRepo();
        TaxiRepo taxiRepo = new TaxiRepo();
        Gestiones gestion = new Gestiones();
        int opcion = 0;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("\tMenu Principal");
            System.out.println("\t1 - Menu Clientes");
            System.out.println("\t2 - Menu Remises");
            System.out.println("\t3 - Menu Taxi");
            System.out.println("\t4 - Pedir Remises");
            System.out.println("\t5 - Pédir Taxi");
            System.out.println("\t0 - Salir\n");
            System.out.println("Ingrese una opción : ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuRemises();
                    break;
                case 3:
                    menuTaxis();
                    break;
                case 4:

                    gestion.pedirUnRemis();

                    break;
                case 5:
                    gestion.pedirUnTaxi();
                    break;
                case 0:
                    System.out.println("Gracias por la visitan\n\nHasta pronto\n");
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        } while (opcion != 0);
    }

    public static void menuClientes() throws MiExcepcion {
        Gestiones gestion = new Gestiones();
        int opcion = 0;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("\tMenu Taxi");
            System.out.println("\t1 - Agregar");
            System.out.println("\t2 - Modificar");
            System.out.println("\t3 - Buscar");
            System.out.println("\t4 - Eliminar");
            System.out.println("\t5 - Mostrar");
            System.out.println("\t0 - Atras\n");
            System.out.println("Ingrese una opción : ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    gestion.agregarCliente();
                    break;
                case 2:
                    gestion.modificacionCliente();
                    break;
                case 3:
                    gestion.buscarCliente();
                    break;
                case 4:
                    gestion.eliminarCliente();
                    break;
                case 5:
                    gestion.mostrarClientes();
                    break;
                case 0:
                    System.out.println("Gracias por la visitan\n\nHasta pronto\n");
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        } while (opcion != 0);
    }

    public static void menuTaxis() throws MiExcepcion {
        Gestiones gestion = new Gestiones();
        int opcion = 0;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("\tMenu Taxi");
            System.out.println("\t1 - Agregar");
            System.out.println("\t2 - Modificar");
            System.out.println("\t3 - Buscar");
            System.out.println("\t4 - Eliminar");
            System.out.println("\t5 - Mostrar");
            System.out.println("\t0 - Atras\n");
            System.out.println("Ingrese una opción : ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    gestion.agregarTaxis();
                    break;
                case 2:
                    gestion.modificacionTaxis();
                    break;
                case 3:
                    gestion.buscarTaxis();
                    break;
                case 4:
                    gestion.eliminarTaxis();
                    break;
                case 5:
                    gestion.mostrarTaxiss();
                    break;
                case 0:
                    System.out.println("Gracias por la visitan\n\nHasta pronto\n");
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        } while (opcion != 0);
    }

    public static void menuRemises() throws MiExcepcion {
        Gestiones gestion = new Gestiones();
        int opcion = 0;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("\tMenu Remises");
            System.out.println("\t1 - Agregar");
            System.out.println("\t2 - Modificar");
            System.out.println("\t3 - Buscar");
            System.out.println("\t4 - Eliminar");
            System.out.println("\t5 - Mostrar");
            System.out.println("\t0 - Atras\n");
            System.out.println("Ingrese una opción : ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    gestion.agregarRemises();
                    break;
                case 2:
                    gestion.modificacionRemises();
                    break;
                case 3:
                    gestion.buscarRemises();
                    break;
                case 4:
                    gestion.eliminarRemises();
                    break;
                case 5:
                    gestion.mostrarRemises();
                    break;
                case 0:
                    System.out.println("Gracias por la visitan\n\nHasta pronto\n");
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        } while (opcion != 0);

    }
//</editor-fold>
}