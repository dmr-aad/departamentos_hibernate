
package metodos;


import java.sql.*;

/**
 *
 * @author a18danielmr
 */
public class Creacion {
    
    public static void crearTablas(Statement s){
        try{
            s.execute("CREATE DATABASE IF NOT EXISTS empleadosdepartamentosdanihibernate");
            
            s.execute("USE empleadosdepartamentosdanihibernate");
            
            s.execute("CREATE TABLE IF NOT EXISTS departamentos("
                    + "id_dep INT(5) UNSIGNED NOT NULL AUTO_INCREMENT, "
                    + "nom_dep VARCHAR(45) NOT NULL, "
                    + "local_dep VARCHAR(45) NOT NULL, "
                    + "PRIMARY KEY(id_dep)"
                    + ")ENGINE = INNODB;");
            
            s.execute("CREATE TABLE IF NOT EXISTS empleados("
                    + "nss_emple VARCHAR(12) NOT NULL, "
                    + "nom_emple VARCHAR(45) NOT NULL, "
                    + "of_emple VARCHAR(45) NOT NULL, "
                    + "dir_emple VARCHAR(45) NOT NULL, "
                    + "fnac_emple DATE NOT NULL, "
                    + "salar_emple INT(5) NOT NULL, "
                    + "comis_emple INT(5) NOT NULL, "
                    + "ndpto_emple INT(5) UNSIGNED NOT NULL, "
                    + "PRIMARY KEY (nss_emple), "
                    + "CONSTRAINT FK_departamento "
                    + "FOREIGN KEY (ndpto_emple) REFERENCES departamentos (id_dep)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE"
                    + ")ENGINE = INNODB;");
            
            
        }catch(SQLException e){
            System.out.println("Error: " + e);
            System.exit(3);
        }
    }
}
