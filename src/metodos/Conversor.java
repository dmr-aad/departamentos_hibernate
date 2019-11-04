
package metodos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author a18danielmr
 */
public class Conversor {
    public static Date fecha(Date fechaActual) throws ParseException {
        DateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = formatoFechaHora.format(fechaActual);
        return formatoFechaHora.parse(strFecha);
    }
}
