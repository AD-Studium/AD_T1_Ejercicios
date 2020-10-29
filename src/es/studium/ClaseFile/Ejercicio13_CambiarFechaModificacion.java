/**
 * Escribe un método que cambie la fecha de última modificación de todos los archivos cuyo nombre tenga exactamente 8 números. 
 * La nueva fecha vendrá dada por el nombre del archivo, que estará escrito siguiendo el patrón "yyyymmdd".
 * Por ejemplo, el archivo "19960812.mp4" cambiará su fecha de última modificación al 12 de agosto de 1996.
 */
package es.studium.ClaseFile;

import java.io.File;
import java.io.FilenameFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Alvca
 *
 */
public class Ejercicio13_CambiarFechaModificacion {
	static Scanner teclado = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Indique la ruta donde quiere renombrar los directorios");
		String directorio = teclado.next();
		teclado.close();
		try {
			ejercicio13(directorio);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void ejercicio13(String pathname) throws ParseException {
		File filePathname = new File(pathname);
		File[] files = filePathname.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File file, String name) {
				return name.matches("\\d{8}.\\w+");
			}
		});
		for (File file : files) {
			String dateString = file.getName().substring(0, 8);
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
			Date newDate = dateFormatter.parse(dateString);
			file.setLastModified(newDate.getTime());
		}
	}
}
