/*
 * Escribe un método estático que cree en el directorio pasado por parámetro una carpeta cuyo nombre sea la fecha actual
 */
package es.studium.ClaseFile;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio06_CrearDirectorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createFolder("C:/Users/Alvca/OneDrive/2 DAM/Aceso a Datos");
	}
	public static void createFolder(String pathname) {
		Date today = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			
		File filePathname = new File(pathname, dateFormat.format(today));
		filePathname.mkdir();
	}
}
