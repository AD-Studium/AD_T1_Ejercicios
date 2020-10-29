/**
 * Escribe un método que cambie la fecha de modificación de todos los archivos del directorio pasado por parámetro. La nueva fecha debe ser 10 días antes de la fecha actual de modificación.
 */
package es.studium.ClaseFile;

import java.io.File;

/**
 * @author Alvca
 *
 */
public class Ejercicio07_CambiarFechaModificacionDirectorio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		changeModified("C:/Users/Alvca/OneDrive/2 DAM/Aceso a Datos");
	}
	public static void changeModified(String pathname) {
		File filePathname = new File(pathname);
		File[] files = filePathname.listFiles();
		long tenDays = 10 * 24 * 60 * 60 * 1000;
		
		for (File f : files) {
			f.setLastModified(f.lastModified() - tenDays);
		}
	}
}
