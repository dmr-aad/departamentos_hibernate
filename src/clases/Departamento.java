
package clases;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a18danielmr
 */
public class Departamento implements Serializable{
    
    private int id_dep;
    private String nom_dep;
    private String local_dep;
    private Set<Empleado> empleados;
    
    public Departamento() {
    }

    public Departamento(String nom_dep, String local_dep) {
        this.nom_dep = nom_dep;
        this.local_dep = local_dep;
        this.empleados = new HashSet<>();
    }

    public int getId_dep() {
        return id_dep;
    }

    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
    }

    public String getNom_dep() {
        return nom_dep;
    }

    public void setNom_dep(String nom_dep) {
        this.nom_dep = nom_dep;
    }

    public String getLocal_dep() {
        return local_dep;
    }

    public void setLocal_dep(String local_dep) {
        this.local_dep = local_dep;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }
    
}
