
package clases;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author a18danielmr
 */
public class Empleado implements Serializable{
    
    private String nss_emple;
    private String nom_emple;
    private String of_emple;
    private String dir_emple;
    private Date fnac_emple;
    private int salar_emple;
    private int comis_emple;
    private Departamento departamento;
    
    public Empleado() {
    }

    public Empleado(String nss_emple, String nom_emple, String of_emple, String dir_emple, Date fnac_emple, int salar_emple, int comis_emple) {
        this.nss_emple = nss_emple;
        this.nom_emple = nom_emple;
        this.of_emple = of_emple;
        this.dir_emple = dir_emple;
        this.fnac_emple = fnac_emple;
        this.salar_emple = salar_emple;
        this.comis_emple = comis_emple;
    }

    public String getNss_emple() {
        return nss_emple;
    }

    public void setNss_emple(String nss_emple) {
        this.nss_emple = nss_emple;
    }

    public String getNom_emple() {
        return nom_emple;
    }

    public void setNom_emple(String nom_emple) {
        this.nom_emple = nom_emple;
    }

    public String getOf_emple() {
        return of_emple;
    }

    public void setOf_emple(String of_emple) {
        this.of_emple = of_emple;
    }

    public String getDir_emple() {
        return dir_emple;
    }

    public void setDir_emple(String dir_emple) {
        this.dir_emple = dir_emple;
    }

    public Date getFnac_emple() {
        return fnac_emple;
    }

    public void setFnac_emple(Date fnac_emple) {
        this.fnac_emple = fnac_emple;
    }

    public int getSalar_emple() {
        return salar_emple;
    }

    public void setSalar_emple(int salar_emple) {
        this.salar_emple = salar_emple;
    }

    public int getComis_emple() {
        return comis_emple;
    }

    public void setComis_emple(int comis_emple) {
        this.comis_emple = comis_emple;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
    
    
}
