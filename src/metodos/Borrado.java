
package metodos;

import clases.Departamento;
import clases.Empleado;
import departamentoempleadoshibernate.NewHibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Mirotic
 */
public class Borrado {
    
    public static void mainBorrar(BufferedReader lee) throws IOException {
        int op;
        op = Menu.borrado(lee);
        switch (op) {
            case 1:
                borrarEmpleado(lee);
                break;
            case 2:
                borrarDepartamento(lee);
                break;
            case 0:
                System.out.println("SALIENDO...");
                break;
        }
    }
    
    public static void borrarDepartamento(BufferedReader lee) throws IOException {
        boolean existe = Visualizar.visualizarDepartamentos();
        int id_dep;
        Departamento d = null;
        if (existe) {
            System.out.println("Introduce el id del departamento");
            id_dep = Integer.parseInt(lee.readLine());
            d = Comprobaciones.comprobarDepartamento(id_dep);
            if (d != null){
                int op = Menu.confirmacion(lee, "¿Está seguro de querer borrar el departamento?");
                if (op == 1){
                    eliminar(d);
                } else {
                    System.out.println("Cancelando borrado");
                }
            } else {
                System.out.println("El departamento no existe");
            }
        } else {
            System.out.println("No hay ningún departamento");
        }
    }
    
    public static void borrarEmpleado(BufferedReader lee) throws IOException {
        boolean existe = Visualizar.visualizarEmpleados();
        String nss_emple;
        Empleado e = null;
        if (existe) {
            System.out.println("Introduce el nss del empleado");
            nss_emple = lee.readLine();
            e = Comprobaciones.comprobarEmpleado(nss_emple);
            if (e != null){
                int op = Menu.confirmacion(lee, "¿Está seguro de querer borrar el empleado?");
                if (op == 1){
                    eliminar(e);
                } else {
                    System.out.println("Cancelando borrado");
                }
            } else {
                System.out.println("El empleado no existe");
            }
        } else {
            System.out.println("No hay ningún empleado");
        }
    }
    
    public static void eliminar(Object objeto) {
        Session sesion;
        try {
            sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.delete(objeto);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
