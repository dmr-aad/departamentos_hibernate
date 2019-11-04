package metodos;

import clases.Departamento;
import clases.Empleado;
import departamentoempleadoshibernate.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Mirotic
 */
public class Comprobaciones {

    public static Departamento comprobarDepartamento(int id_dep) {

        Session sesion;
        Departamento d = null;
        try {
            sesion = NewHibernateUtil.getSession();
            d = (Departamento) sesion.get(Departamento.class, id_dep);
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

        return d;
    }

    public static boolean comprobarDepartamentoNom(String nom_dep) {
        boolean existe = false;
        Session sesion;
        try {
            sesion = NewHibernateUtil.getSession();
            List<Object> departamentos = sesion.createCriteria(Departamento.class).list();
            for (Object departamento : departamentos) {
                if (((Departamento) departamento).getNom_dep().equalsIgnoreCase(nom_dep)) {
                    existe = true;
                }
            }
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

        return existe;
    }

    public static Empleado comprobarEmpleado(String nss_emple) {

        Session sesion;
        Empleado e = null;
        try {
            sesion = NewHibernateUtil.getSession();
            e = (Empleado) sesion.get(Empleado.class, nss_emple);
            sesion.close();
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return e;
    }

    public static boolean comprobarEmpleadoNom(String nom_emple) {
        boolean existe = false;
        Session sesion;
        try {
            sesion = NewHibernateUtil.getSession();
            List<Object> empleados = sesion.createCriteria(Empleado.class).list();
            for (Object empleado : empleados) {
                if (((Empleado) empleado).getNom_emple().equalsIgnoreCase(nom_emple)) {
                    existe = true;
                }
            }
            sesion.close();
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return existe;
    }

    public static Empleado añadirEmpleadoNom(String nom_emple) {
        Session sesion;
        Empleado e = null;
        try {
            sesion = NewHibernateUtil.getSession();
            List<Object> empleados = sesion.createCriteria(Empleado.class).list();
            for (Object empleado : empleados) {
                if (((Empleado) empleado).getNom_emple().equalsIgnoreCase(nom_emple)){
                    e = (Empleado) empleado;
                }
            }
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return e;
    }
    
    public static Departamento añadirDepartamentoNom(String nom_dep){
        Session sesion;
        Departamento d = null;
        try {
            sesion = NewHibernateUtil.getSession();
            List<Object> departamentos = sesion.createCriteria(Departamento.class).list();
            for (Object departamento : departamentos) {
                if (((Departamento) departamento).getNom_dep().equalsIgnoreCase(nom_dep)){
                    d = (Departamento) departamento;
                }
            }
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
        }
        return d;
    }
}
