/**
 * Modifica el ejercicio anterior para que aparezcan primero los directorios y luego los archivos.
 */
package es.studium.ClaseFile;

import java.io.File;
import java.util.Arrays;

/**
 * @author Alvca
 *
 */
public class Ejercicio02_MostarElementosDirectorioOrdenado_Streams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dir ("C:/Users/Alvca/OneDrive/2 DAM/Aceso a Datos");
	}
	public static void dir(String pathname) {
		File[] files = (new File(pathname)).listFiles();
		System.out.println(" Contenido de la carpeta " + pathname + "\n");
		Arrays.stream(files).filter(file -> file.isDirectory())
				.forEach(file -> System.out.println("<DIR>\t" + file.getName()));
		Arrays.stream(files).filter(file -> file.isFile()).forEach(file -> System.out.println("\t" + file.getName()));
	}
}
