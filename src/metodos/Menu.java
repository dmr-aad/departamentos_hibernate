
package metodos;

import java.io.*;

/**
 *
 * @author Mirotic
 */
public class Menu {
    
    public static int principal(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_HIBERNATE***\n"
                + "1. Inserción de nuevas filas\n"
                + "2. Borrado de filas\n"
                + "3. Consultas\n"
                + "4. Modificaciones\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int insercion(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_INSERCIONES***\n"
                + "1. Inserción empleado\n"
                + "2. Inserción departamento\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int borrado(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_BORRADO***\n"
                + "1. Borrado empleado\n"
                + "2. Borrado departamento\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int consultas(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_CONSULTAS***\n"
                + "1. Visualizar datos empleados de un departamento\n"
                + "2. Visualizar departamento y localidad de un empleado\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int modificaciones(BufferedReader lee) throws IOException {
        int op;
        System.out.println("***MENU_MODIFICACIONES***\n"
                + "1. Modificar salario o comisión\n"
                + "2. Modificar localidad\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int modificarEmple(BufferedReader lee) throws IOException {
        int op;
        System.out.println("¿Que campo desea modificar?\n"
                + "1. Salario\n"
                + "2. Comisión\n"
                + "0. Salir");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
    
    public static int confirmacion(BufferedReader lee, String mensaje) throws IOException {
        int op;
        System.out.println(mensaje + "\n"
                + "1. Si\n"
                + "2. No");
        op = Integer.parseInt(lee.readLine());
        return op;
    }
}
