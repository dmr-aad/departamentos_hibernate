package departamentoempleadoshibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.ParseException;
import metodos.*;

/**
 *
 * @author a18danielmr
 */
public class DepartamentoEmpleadosHibernate {

    static Connection conex;
    static Statement s;
    static ResultSet rs;

    public static void main(String[] args) throws IOException, ParseException {
        String url = "jdbc:mysql://localhost:3307/?user=root&password=usbw";
        int op;
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        try {
            conex = DriverManager.getConnection(url);
            s = conex.createStatement();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.exit(1);
        }
        try {
            if (!s.executeQuery("SHOW DATABASES LIKE 'empleadosdepartamentosdanihibernate'").first()) {
                Creacion.crearTablas(s);
            } else {
                s.execute("USE empleadosdepartamentosdanihibernate");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.exit(2);
        }

        NewHibernateUtil.getSessionFactory();

        do {
            op = Menu.principal(lee);
            switch (op) {
                case 1:
                    Inserciones.mainInsertar(lee);
                    break;
                case 2:
                    Borrado.mainBorrar(lee);
                    break;
                case 3:
                    Consultas.mainConsultar(lee);
                    break;
                case 4:
                    Modificaciones.mainModificar(lee);
                    break;
                case 0:
                    System.out.println("SALIENDO...");
                    NewHibernateUtil.getSessionFactory().close();
                    break;
            }
        } while (op != 0);
    }
}
