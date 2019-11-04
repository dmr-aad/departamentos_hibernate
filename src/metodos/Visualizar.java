
package metodos;

import clases.Departamento;
import clases.Empleado;
import departamentoempleadoshibernate.NewHibernateUtil;
import java.util.Arrays;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Mirotic
 */
public class Visualizar {
    public static boolean visualizarDepartamentos() {
        try{
            Session sesion;
            sesion = NewHibernateUtil.getSession();
            //Guarda en una lista los datos de los departamentos añadidos
            List<Object> departamentos = sesion.createCriteria(Departamento.class).list();
            sesion.close();
            //Si la lista no está vacia
            if (!departamentos.isEmpty()) {
                System.out.println("idDep\t\tnom_dep\t\tlocal_dep");
                for (Object departamento : departamentos) {
                    System.out.println(((Departamento) departamento).getId_dep() + "\t\t" + ((Departamento) departamento).getNom_dep()+ "\t\t" + ((Departamento) departamento).getLocal_dep());
                }
                return true;
            } else {
                System.out.println("No hay departamentos");
                return false;
            }
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public static boolean visualizarEmpleados() {
        try{
            Session sesion;
            sesion = NewHibernateUtil.getSession();
            List<Object> empleados = sesion.createCriteria(Empleado.class).list();
            sesion.close();
            if (!empleados.isEmpty()) {
                System.out.println("nss_emple\t\tnom_emple");
                for (Object empleado : empleados) {
                    System.out.println(((Empleado) empleado).getNss_emple() + "\t\t" + ((Empleado) empleado).getNom_emple());
                }
                return true;
            } else {
                System.out.println("No hay empleados");
                return false;
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
