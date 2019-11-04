package metodos;

import clases.Departamento;
import clases.Empleado;
import departamentoempleadoshibernate.NewHibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author Mirotic
 */
public class Consultas {

    public static void mainConsultar(BufferedReader lee) throws IOException {
        int op;
        op = Menu.consultas(lee);
        switch (op) {
            case 1:
                datosEmpleados(lee);
                break;
            case 2:
                datosDepartamento(lee);
                break;
            case 0:
                System.out.println("SALIENDO...");
                break;
        }
    }

    public static void datosEmpleados(BufferedReader lee) throws IOException {
        boolean existe = Visualizar.visualizarEmpleados();
        boolean existeDep;
        String nom_dep;
        if (existe) {
            System.out.println("Introduce el nombre de un departamento");
            nom_dep = lee.readLine();
            existeDep = Comprobaciones.comprobarDepartamentoNom(nom_dep);
            if (existeDep) {
                Departamento d = Comprobaciones.añadirDepartamentoNom(nom_dep);
                System.out.println("Datos de los empleados del departamento: " + d.getNom_dep());
                System.out.println("nss_emple\t\t"
                        + "nom_emple\t\t"
                        + "of_emple\t\t"
                        + "dir_emple\t\t"
                        + "fnac_emple\t\t"
                        + "salar_emple\t\t"
                        + "comis_emple\t\t");
                for (Empleado e : d.getEmpleados()) {
                    System.out.println(e.getNss_emple() + "\t\t"
                            + e.getNom_emple() + "\t\t"
                            + e.getOf_emple() + "\t\t"
                            + e.getDir_emple() + "\t\t"
                            + e.getFnac_emple() + "\t\t"
                            + e.getSalar_emple() + "\t\t"
                            + e.getComis_emple());
                }
            } else {
                System.out.println("El departamento introducido no existe");
            }
        } else {
            System.out.println("No existe ningún empleado");
        }
    }

    public static void datosDepartamento(BufferedReader lee) throws IOException {
        boolean existe = Visualizar.visualizarDepartamentos();
        boolean existeEmple;
        String nom_emple;
        Session sesion;
        if (existe) {
            System.out.println("Introduce el nombre de un empleado");
            nom_emple = lee.readLine();
            sesion = NewHibernateUtil.getSession();
            ArrayList<Empleado> e = new ArrayList<>();
            List<Object> empleados = sesion.createCriteria(Empleado.class).list();
            for (Object empleado : empleados) {
                if (((Empleado) empleado).getNom_emple().equalsIgnoreCase(nom_emple)) {
                    e.add((Empleado) empleado);
                }
            }
            existeEmple = Comprobaciones.comprobarEmpleadoNom(nom_emple);
            if (existeEmple) {
                System.out.println("nom_dep\t\tlocal_dep");
                for (Empleado empleado : e) {
                    Departamento d = Comprobaciones.comprobarDepartamento(empleado.getDepartamento().getId_dep());
                    System.out.println(d.getNom_dep() + "\t\t" + d.getLocal_dep());
                }
            } else {
                System.out.println("No existe ningún empleado con ese nombre");
            }
        }
    }
}
