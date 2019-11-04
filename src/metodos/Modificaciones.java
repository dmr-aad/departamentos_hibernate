package metodos;

import clases.Departamento;
import clases.Empleado;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Mirotic
 */
public class Modificaciones {
    
    public static void mainModificar(BufferedReader lee) throws IOException {
        int op;
        op = Menu.modificaciones(lee);
        switch (op) {
            case 1:
                modificarEmpleado(lee);
                break;
            case 2:
                modificarDepartamento(lee);
                break;
            case 0:
                System.out.println("SALIENDO...");
                break;
        }
    }

    public static void modificarEmpleado(BufferedReader lee) throws IOException {
        boolean existe = Visualizar.visualizarEmpleados();
        boolean existeEmple;
        String nom_emple;
        Empleado e = null;
        if (existe) {
            System.out.println("Introduce el nombre del empleado a modificar");
            nom_emple = lee.readLine();
            existeEmple = Comprobaciones.comprobarEmpleadoNom(nom_emple);
            if (existeEmple) {
                e = Comprobaciones.añadirEmpleadoNom(nom_emple);
                int op = Menu.modificarEmple(lee);
                switch (op) {
                    case 1:
                        modificarSalario(lee, e);
                        break;
                    case 2:
                        modificarComision(lee, e);
                        break;
                    case 0:
                        System.out.println("SALIENDO...");
                        break;
                }
            } else {
                System.out.println("No existe ningún empleado con ese nombre");
            }
        } else {
            System.out.println("No hay ningún empleado");
        }
    }

    public static void modificarSalario(BufferedReader lee, Empleado e) throws IOException {
        int salario;
        System.out.println("Salario actual del empleado: " + e.getSalar_emple());
        System.out.println("Introduzca el nuevo salario: ");
        salario = Integer.parseInt(lee.readLine());
        int op = Menu.confirmacion(lee, "¿Está seguro de querer modificar el salario?");
        if (op == 1) {
            e.setSalar_emple(salario);
            Inserciones.guardarModificar(e);
            System.out.println("Salario modificado");
        } else {
            System.out.println("Modificación cancelada");
        }
    }

    public static void modificarComision(BufferedReader lee, Empleado e) throws IOException {
        int comision;
        System.out.println("Comisión actual del empleado: " + e.getComis_emple());
        System.out.println("Introduzca la nueva comisión: ");
        comision = Integer.parseInt(lee.readLine());
        int op = Menu.confirmacion(lee, "¿Está seguro de querer modificar la comisión?");
        if (op == 1) {
            e.setComis_emple(comision);
            Inserciones.guardarModificar(e);
            System.out.println("Comisión modificada");
        } else {
            System.out.println("Modificación cancelada");
        }
    }

    public static void modificarDepartamento(BufferedReader lee) throws IOException {
        boolean existe = Visualizar.visualizarDepartamentos();
        boolean existeDep;
        String nom_dpto;
        String local_dep;
        Departamento d = null;
        if (existe) {
            System.out.println("Introduce el nombre del departamento a modificar");
            nom_dpto = lee.readLine();
            existeDep = Comprobaciones.comprobarDepartamentoNom(nom_dpto);
            if (existeDep) {
                d = Comprobaciones.añadirDepartamentoNom(nom_dpto);
                System.out.println("Localidad actual del departamento: " + d.getLocal_dep());
                System.out.println("Introduzca la nueva localidad: ");
                local_dep = lee.readLine();
                int op = Menu.confirmacion(lee, "¿Está seguro de querer modificar la localidad?");
                if (op == 1) {
                    d.setLocal_dep(local_dep);
                    Inserciones.guardarModificar(d);
                    System.out.println("Localidad modificada");
                } else {
                    System.out.println("Modificación cancelada");
                }
            } else {
                System.out.println("No existe ningún departamento con ese nombre");
            }
        } else {
            System.out.println("No hay ningún departamento");
        }
    }
}
