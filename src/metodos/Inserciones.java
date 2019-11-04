package metodos;

import clases.Departamento;
import clases.Empleado;
import departamentoempleadoshibernate.NewHibernateUtil;
import java.io.*;
import java.text.ParseException;
import java.util.Date;
import org.hibernate.*;

/**
 *
 * @author Mirotic
 */
public class Inserciones {

    public static void mainInsertar(BufferedReader lee) throws IOException, ParseException {
        int op;
        op = Menu.insercion(lee);
        switch (op) {
            case 1:
                insertarEmpleado(lee);
                break;
            case 2:
                insertarDepartamento(lee);
                break;
            case 0:
                System.out.println("SALIENDO...");
                break;
        }
    }

    public static void insertarEmpleado(BufferedReader lee) throws IOException, ParseException {
        String nom_emple, of_emple, dir_emple;
        String nss_emple;
        Date fnac_emple;
        int salar_emple, comis_emple;
        System.out.println("Introduce el NUSS del empleado");
        nss_emple = lee.readLine();
        System.out.println("Introduce el nombre del empleado");
        nom_emple = lee.readLine();
        System.out.println("Introduce el oficio del empleado");
        of_emple = lee.readLine();
        System.out.println("Introduce la dirección del empleado");
        dir_emple = lee.readLine();
        Date fechaActual = new Date();
        fnac_emple = Conversor.fecha(fechaActual);
        System.out.println("Introduce el salario del empleado");
        salar_emple = Integer.parseInt(lee.readLine());
        System.out.println("Introduce la comisión del empleado");
        comis_emple = Integer.parseInt(lee.readLine());
        Empleado e = new Empleado(nss_emple, nom_emple, of_emple, dir_emple, fnac_emple, salar_emple, comis_emple);
        Departamento d = null;
        do {
            boolean existe = Visualizar.visualizarDepartamentos();
            if (existe) {
                d = buscarDepartamento(lee);
                if (d == null) {
                    int op = Menu.confirmacion(lee, "El departamento introducido no existe, ¿desea crearlo?");
                    if (op == 1) {
                        d = crearDepartamento(e, lee);
                    }
                }
            } else {
                d = crearDepartamento(e, lee);
            }
        } while (d == null);

        e.setDepartamento(d);
        guardarModificar(e);
        System.out.println("Empleado Introducido");
    }

    public static void insertarDepartamento(BufferedReader lee) throws IOException, ParseException {
        String nom_dep, local_dep;
        boolean existe;
        Departamento d = null;
        do {
            System.out.println("Introduce el nombre del departamento");
            nom_dep = lee.readLine();
            existe = Comprobaciones.comprobarDepartamentoNom(nom_dep);
            if (existe) {
                System.out.println("Ya existe un departamento con ese nombre");
            }
        } while (existe);
        System.out.println("Introduce la localidad del departamento");
        local_dep = lee.readLine();
        d = new Departamento(nom_dep, local_dep);
        guardarModificar(d);
        int op = Menu.confirmacion(lee, "¿Desea introducir un empleado en este departamento?");
        if (op == 1) {
            do {
                Empleado e = crearEmpleado(d, lee);
                d.getEmpleados().add(e);
                guardarModificar(e);
                op = Menu.confirmacion(lee, "¿Desea añadir otro empleado para este departamento?");
            } while (op == 1);
        }
        guardarModificar(d);
        System.out.println("Departamento Introducido");
    }

    public static Empleado crearEmpleado(Departamento d, BufferedReader lee) throws IOException, ParseException {
        String nom_emple, of_emple, dir_emple;
        String nss_emple;
        Date fnac_emple;
        int salar_emple, comis_emple;
        System.out.println("Introduce el NUSS del empleado");
        nss_emple = lee.readLine();
        System.out.println("Introduce el nombre del empleado");
        nom_emple = lee.readLine();
        System.out.println("Introduce el oficio del empleado");
        of_emple = lee.readLine();
        System.out.println("Introduce la dirección del empleado");
        dir_emple = lee.readLine();
        Date fechaActual = new Date();
        fnac_emple = Conversor.fecha(fechaActual);
        System.out.println("Introduce el salario del empleado");
        salar_emple = Integer.parseInt(lee.readLine());
        System.out.println("Introduce la comisión del empleado");
        comis_emple = Integer.parseInt(lee.readLine());
        Empleado e = new Empleado(nss_emple, nom_emple, of_emple, dir_emple, fnac_emple, salar_emple, comis_emple);
        e.setDepartamento(d);
        return e;
    }

    public static Departamento crearDepartamento(Empleado e, BufferedReader lee) throws IOException {
        String nom_dep, local_dep;
        boolean existe;
        Departamento d = null;
        do {
            System.out.println("Escribe el nombre del departamento");
            nom_dep = lee.readLine();
            existe = Comprobaciones.comprobarDepartamentoNom(nom_dep);
            if (existe) {
                System.out.println("Ya existe un departamento con ese nombre");
            }
        } while (existe);
        System.out.println("Escribe la localidad del departamento");
        local_dep = lee.readLine();
        d = new Departamento(nom_dep, local_dep);
        d.getEmpleados().add(e);
        guardarModificar(d);
        return d;
    }

    public static Departamento buscarDepartamento(BufferedReader lee) throws IOException {
        Departamento d = null;
        Session sesion;
        int ndpto;

        System.out.println("Introduce el numero de departamento");
        ndpto = Integer.parseInt(lee.readLine());
        try {
            sesion = NewHibernateUtil.getSession();
            d = (Departamento) sesion.get(Departamento.class, ndpto);
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return d;
    }

    public static void guardarModificar(Object objeto) {
        Session sesion;
        try {
            sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.saveOrUpdate(objeto);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
